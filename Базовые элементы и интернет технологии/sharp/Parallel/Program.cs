using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;

namespace Parallel
{
    class Program
    {
        static void Main(string[] args)
        {
            //ThreadExample();
            //TaskExample();
            ArrayThreadExampleRun();


            Console.ReadLine();
        }

        /// <summary>
        /// Пример запуска потоков
        /// </summary>
        public static void ThreadExample()
        {
            Console.WriteLine("Пример использования \"старого\" варианта многопоточности с использованием класса Thread");
            const int n = 10;
            Thread[] threads = new Thread[n];
            for (int i = 0; i < n; i++)
            {
                threads[i] = new Thread(new ParameterizedThreadStart(ThreadRun));
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

        public static void TaskExample()
        {
            Console.WriteLine("Пример использования \"нового\" варианта многопоточности с использованием класса Task");
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

        public static void ArrayThreadExampleRun()
        {
            //Размерность массива
            const int n = 1000000;
            //Делитель
            int divider = 5;

            //Количество потоков
            const int threadCount = 1000;
            //Приращение потоков
            const int threadStep = 100;


            ArrayThreadExample(100, 10, 3);

            /*
            //Перебор элементов
            for (int i = 1; i < threadCount; i += threadStep)
            {
                ArrayThreadExample(n, i, divider);
            }
             */ 
        }


        public static void ArrayThreadExample(int ArrayLength, int ThreadCount, int Divider)
        {
            //Результирующий список чисел 
            List<int> Result = new List<int>();

            //Создание и заполнение временного списка данных
            List<int> tempList = new List<int>();
            for (int i = 0; i < ArrayLength; i++) tempList.Add(i+1);

            //Деление списка на фрагменты для параллельного запуска в потоках
            List<MinMax> arrayDivList = SubArrays.DivideSubArrays(0, ArrayLength, ThreadCount);
            int count = arrayDivList.Count;

            Stopwatch timer = new Stopwatch();
            timer.Start();

            //Количество потоков соответствует количеству фрагментов массива
            Task<List<int>>[] tasks = new Task<List<int>>[count];

            //Запуск потоков
            for(int i=0; i<count; i++)
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

            Task.WaitAll(tasks);

            timer.Stop();

            //Объединение результатов
            for (int i = 0; i < count; i++)
            {
                Console.Write("Поток " + i.ToString() + ": ");
                foreach (var x in tasks[i].Result) Console.Write(x.ToString() + " ");
                Console.WriteLine();

                Result.AddRange(tasks[i].Result);
            }

            //Task<List<string>> t1;
            //t1.re

            Console.WriteLine("Массив из {0} элементов обработан {1} потоками за {2}. Найдено: {3}", ArrayLength, count, timer.Elapsed, Result.Count);

            
            //Вывод результатов
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
            return tempData;
        }


    }
}
