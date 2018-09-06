using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GenericClass
{
    /// <summary>
    /// Обобщенный класс
    /// </summary>
    /// <typeparam name="T"></typeparam>
    class GenericClass1<T>
    {
        private T i;
        
        //Конструктор
        public GenericClass1(T param) { this.i = param; }

        //Приведение к строке
        public override string ToString()
        {
            return i.ToString();
        }
    }

    //Обощенный класс с ограничением

    interface I1
    {
        string I1_method();
    }

    class I1_class : I1
    {
        string str;

        public I1_class(string param) 
        { 
            this.str = param; 
        }

        public string I1_method() { return this.str; }
    }

    //where T : I1 - ограничение на то, что T должен реализовывать интерфейс I1
    class GenericClass2<T> where T : I1
    {
        private T i;

        //Конструктор
        public GenericClass2(T param) { this.i = param; }

        //Приведение к строке
        public override string ToString()
        {
            return i.I1_method();
        }
    }


    class Program
    {
        static void Main(string[] args)
        {
            GenericClass1<int> g1 = new GenericClass1<int>(333);
            Console.WriteLine("Обобщенный класс: " + g1);

            GenericClass2<I1_class> g2 = new GenericClass2<I1_class>(new I1_class("Обобщенный класс с ограничением"));
            Console.WriteLine(g2);

            ///////////////////////////////
            //список ограничений - стр.170
            ///////////////////////////////

            //Вызов обощенного метода
            GenericMethod<I1_class>(new I1_class("Вызов обобщенного метода"));

            Console.ReadLine();
        }

        /// <summary>
        /// Примеры обобщенных методов
        /// </summary>
        static void GenericMethod<T>(T param) where T : I1
        {
            Console.WriteLine(param.I1_method());
        }

        static void GenericMethod2<T,Q>(T param1, Q param2) {}
    }
}
