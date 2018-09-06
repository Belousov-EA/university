using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegates
{

    //Делегаты - аналог процедурного типа в Паскале.
    //Делегат - это не тип класса, а тип метода.
    //Делегат определяет сигнатуру метода (типы параметров и возвращаемого значения).
    //Если создается метод типа делегата, то у него должна быть сигнатура как у делегата.
    //Метод типа делегата можно передать как параметр другому методу.

    //Название делегата при объявлении указывается "вместо" названия метода
    delegate int PlusOrMinus(int p1, int p2);

    class Program
    {
        //Методы, реализующие делегат (методы "типа" делегата)
        static int Plus(int p1, int p2) { return p1 + p2; }
        static int Minus(int p1, int p2) { return p1 - p2; }

        /// <summary>
        /// Использование обощенного делегата Func<>
        /// </summary>
        static void PlusOrMinusMethodFunc(string str, int i1, int i2, Func<int, int, int> PlusOrMinusParam)
        {
            int Result = PlusOrMinusParam(i1, i2);
            Console.WriteLine(str + Result.ToString());

            // Func<int, string, bool> - делегат принимает параметры типа int и string и возвращает bool          

            // Если метод должен возвращать void, то используется делегат Action
            // Action<int, string> - делегат принимает параметры типа int и string и возвращает void
            // Action как правило используется для разработки групповых делегатов, которые используются в событиях 

        }

        /// <summary>
        /// Использование делегата
        /// </summary>
        static void PlusOrMinusMethod(string str, int i1, int i2, PlusOrMinus PlusOrMinusParam)
        {
            int Result = PlusOrMinusParam(i1, i2);
            Console.WriteLine(str + Result.ToString());
        }

        static void Main(string[] args)
        {
            int i1 = 3;
            int i2 = 2;

            PlusOrMinusMethod("Плюс: ", i1, i2, Plus);
            PlusOrMinusMethod("Минус: ", i1, i2, Minus);

            //Создание экземпляра делегата на основе метода
            PlusOrMinus pm1 = new PlusOrMinus(Plus);
            PlusOrMinusMethod("Создание экземпляра делегата на основе метода: ", i1, i2, pm1);

            //Создание экземпляра делегата на основе 'предположения' делегата
            //Компилятор 'пердполагает' что метод Plus типа делегата
            PlusOrMinus pm2 = Plus;
            PlusOrMinusMethod("Создание экземпляра делегата на основе 'предположения' делегата: ", i1, i2, pm2);

            //Создание анонимного метода
            PlusOrMinus pm3 = delegate (int param1, int param2)
            {
                return param1 + param2;
            };
            PlusOrMinusMethod("Создание экземпляра делегата на основе анонимного метода: ", i1, i2, pm2);

            //Лямбда-выражение в виде переменной
            PlusOrMinus pm4 = (int x, int y) =>
            {
                int z = x + y;
                return z;
            };
            int test = pm4(1, 2);
            PlusOrMinusMethod("Создание экземпляра делегата на основе лямбда-выражения в виде переменной: ", i1, i2, pm4);

            //Пример использования внешней переменной
            int outer = 100;
            PlusOrMinus pm5 = (int x, int y) =>
            {
                int z = x + y + outer;
                return z;
            };
            int test2 = pm5(1, 2);

            PlusOrMinusMethod("Создание экземпляра делегата на основе лямбда-выражения 1: ", i1, i2,
                (int x, int y) =>
                {
                    int z = x + y;
                    return z;
                }
                );

            PlusOrMinusMethod("Создание экземпляра делегата на основе лямбда-выражения 2: ", i1, i2,
                (x, y) =>
                {
                    return x + y;
                }
                );

            PlusOrMinusMethod("Создание экземпляра делегата на основе лямбда-выражения 3: ", i1, i2, (x, y) => x + y);



            ////////////////////////////////////////////////////////////////
            Console.WriteLine("\n\nИспользование обощенного делегата Func<>");

            PlusOrMinusMethodFunc("Создание экземпляра делегата на основе метода: ", i1, i2, Plus);

            string OuterString = "ВНЕШНЯЯ ПЕРЕМЕННАЯ";

            PlusOrMinusMethodFunc("Создание экземпляра делегата на основе лямбда-выражения 1: ", i1, i2,
                (int x, int y) =>
                {
                    Console.WriteLine("Эта переменная объявлена вне лямбда-выражения: " + OuterString);
                    int z = x + y;
                    return z;
                }
                );

            PlusOrMinusMethodFunc("Создание экземпляра делегата на основе лямбда-выражения 2: ", i1, i2,
                (x, y) =>
                {
                    return x + y;
                }
                );

            PlusOrMinusMethodFunc("Создание экземпляра делегата на основе лямбда-выражения 3: ", i1, i2, (x, y) => x + y);


            //////////////////////////////////////////////////////////////
            //Групповой делегат всегда возвращает значение типа void
            Console.WriteLine("Пример группового делегата");
            Action<int, int> a1 = (x, y) => { Console.WriteLine("{0} + {1} = {2}", x, y, x + y); };
            Action<int, int> a2 = (x, y) => { Console.WriteLine("{0} - {1} = {2}", x, y, x - y); };
            Action<int, int> group = a1 + a2;
            group(5, 3);

            Action<int, int> group2 = a1;
            Console.WriteLine("Добавление вызова метода к групповому делегату");
            group2 += a2;
            group2(10, 5);
            Console.WriteLine("Удаление вызова метода из группового делегата");
            group2 -= a1;
            group2(20, 10);

            Console.ReadLine();
        }
    }
}
