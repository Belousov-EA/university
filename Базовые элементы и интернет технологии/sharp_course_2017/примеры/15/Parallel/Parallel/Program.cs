using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Parallel
{
    class Program
    {
        static void Main(string[] args)
        {
            //////////////////////////////////////////////////////////////////
            //Необходимо снять комментарий с одного из вызовов функций:
            //ThreadExample();
            //TaskExample();
            //ArrayThreadExample(100, 10, 3);
            DelayAsyncDemo();
            //////////////////////////////////////////////////////////////////

            Console.ReadLine();
        }

        /// <summary>
        /// Пример запуска потоков
        /// </summary>
        public static void ThreadExample()
        {
            Console.WriteLine("Пример использования \"старого\" варианта многопоточности с использованием класса Thread:");
            const int n = 10;
            Thread[] threads = new Thread[n];
            for (int i = 0; i < n; i++)
            {
                threads[i] = new Thread(ThreadRun);
            }
            for (int i = 0; i < n; i++)
            {
                threads[i].Start("Поток №" + i.ToString());
            }
        }

        /// <summary>
        /// Метод, запускаемый в потоке
        /// </summary>
        /// <param name="param"></param>
        public static void ThreadRun(object param)
        {
            Random r = new Random();
            int delay = r.Next(3000, 10000);
            Thread.Sleep(delay);
            Console.WriteLine(param.ToString());
        }

        /// <summary>
        /// Пример запуска потоков с использованием Task
        /// </summary>
        public static void TaskExample()
        {
            Console.WriteLine("Пример использования \"нового\" варианта многопоточности с использованием класса Task:");
            const int n = 10;
            for (int i = 0; i < n; i++)
            {
                Task.Factory.StartNew(
                    (object param) =>
                    {
                        Random r = new Random();
                        int delay = r.Next(3000, 10000);
                        Thread.Sleep(delay);
                        Console.WriteLine(param.ToString());
                    },
                    "Поток №" + i.ToString());
            }
        }

        ////////////////////////////////////////////////////////////
        // Многопоточная обработка массива
        ////////////////////////////////////////////////////////////

        /// <summary>
        /// Многопоточный поиск в массиве
        /// </summary>
        public static void ArrayThreadExample(int ArrayLength, int ThreadCount, int Divider)
        {
            //Результирующий список чисел 
            List<int> Result = new List<int>();

            //Создание и заполнение временного списка данных
            List<int> tempList = new List<int>();
            for (int i = 0; i < ArrayLength; i++) tempList.Add(i + 1);

            //Деление списка на фрагменты для параллельного запуска в потоках
            List<MinMax> arrayDivList = SubArrays.DivideSubArrays(0, ArrayLength, ThreadCount);
            int count = arrayDivList.Count;

            //Вывод диапазонов деления исходного массива
            for (int i = 0; i < count; i++)
            {
                //Вывод результатов, найденных в каждом потоке
                Console.WriteLine("Диапазон " + i.ToString() + ": " + arrayDivList[i].Min + " - " + arrayDivList[i].Max);
            }
            Console.WriteLine();

            //Создание таймера
            Stopwatch timer = new Stopwatch();
            //Запуск таймера
            timer.Start();

            //Количество потоков соответствует количеству фрагментов массива
            Task<List<int>>[] tasks = new Task<List<int>>[count];

            //Запуск потоков
            for (int i = 0; i < count; i++)
            {
                //Создание временного списка, чтобы потоки не работали параллельно с одной коллекцией
                List<int> tempTaskList = tempList.GetRange(arrayDivList[i].Min, arrayDivList[i].Max - arrayDivList[i].Min);

                tasks[i] = new Task<List<int>>(
                    //Метод, который будет выполняться в потоке
                    ArrayThreadTask,
                    //Параметры потока передаются в виде кортежа, чтобы не создавать временный класс
                    new Tuple<List<int>, int>(tempTaskList, Divider));

                //Запуск потока
                tasks[i].Start();
            }

            //Ожидание завершения всех потоков
            Task.WaitAll(tasks);

            //Остановка таймера
            timer.Stop();

            //Объединение результатов полученных из разных потоков
            for (int i = 0; i < count; i++)
            {
                //Вывод результатов, найденных в каждом потоке
                Console.Write("Поток " + i.ToString() + ": ");
                foreach (var x in tasks[i].Result) Console.Write(x.ToString() + " ");
                Console.WriteLine();

                //Добавление результатов конкретного потока в общий массив результатов
                Result.AddRange(tasks[i].Result);
            }

            //Вывод общего массива результатов
            Console.WriteLine("\nМассив из {0} элементов обработан {1} потоками за {2}. Найдено: {3}", ArrayLength, count, timer.Elapsed, Result.Count);
            foreach (int i in Result) Console.Write(i.ToString().PadRight(5));
            Console.WriteLine();
        }

        /// <summary>
        /// Выполняется в параллельном потоке для поиска числа
        /// </summary>
        /// <param name="param"></param>
        public static List<int> ArrayThreadTask(object paramObj)
        {
            //Получение параметров
            Tuple<List<int>, int> param = (Tuple<List<int>, int>)paramObj;
            int listCount = param.Item1.Count;

            //Временный список для результата
            List<int> tempData = new List<int>();

            //Перебор нужных элементов в списке данных
            for (int i = 0; i < listCount; i++)
            {
                //Текущее значение из массива
                int temp = param.Item1[i];

                //Если число делится без остатка на делитель, то сохраняем в результат
                if ((temp % param.Item2) == 0)
                {
                    tempData.Add(temp);
                }
            }

            //Возврат массива данных
            return tempData;
        }

        ////////////////////////////////////////////////////////////
        // Асинхронные методы
        ////////////////////////////////////////////////////////////

        /// <summary>
        /// Задача для запуска
        /// </summary>
        static Task<string> GetTaskAsync()
        {
            //Создание задачи
            Task<string> t = new Task<string>(
                () =>
                {
                    Thread.Sleep(3000);
                    return "После задержки в 3 секунды.";
                }
                );
            //Запуск задачи
            t.Start();
            //Задача возвращается в качестве результата
            return t;
        }

        /// <summary>
        /// Асинхронный метод
        /// </summary>
        static async void DelayAsync()
        {
            string Result = await GetTaskAsync();
            Console.WriteLine(Result);
        }

        static void DelayAsyncDemo()
        {
            DelayAsync();
            Console.WriteLine("\nПеред вызовом DelayAsync");
        }

    }
}
