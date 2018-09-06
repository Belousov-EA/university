using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Generics
{
    /// <summary>
    /// Обобщенный класс
    /// </summary>
    /// <typeparam name="T">Обобщенный тип</typeparam>
    class GenericClass1<T>
    {
        private T i;

        /// <summary>
        /// Конструктор
        /// </summary>
        public GenericClass1()
        {
            this.i = default(T);
        }

        /// <summary>
        /// Метод инициализации значения
        /// </summary>
        public void SetValue(T param)
        {
            this.i = param;
        }

        /// <summary>
        /// Приведение к строке
        /// </summary>
        public override string ToString()
        {
            return i.ToString();
        }
    }

    /// <summary>
    /// Интерфейс, который используется для ограничения
    /// </summary>
    interface I1
    {
        string I1_method();
    }

    /// <summary>
    /// Класс, реализующий интерфейс для создания объектов обобщенного типа
    /// </summary>
    class I1_class : I1
    {
        string str;

        public I1_class(string param)
        {
            this.str = param;
        }

        public string I1_method() { return this.str; }
    }

    /// <summary>
    /// Обобщенный класс с ограничением
    /// where T : I1 - ограничение на то, что T должен реализовывать интерфейс I1
    /// </summary>
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
            GenericClass1<int> g1 = new GenericClass1<int>();
            g1.SetValue(333);
            Console.WriteLine("Обобщенный класс 1: " + g1);

            GenericClass1<string> g1Str = new GenericClass1<string>();
            g1Str.SetValue("строка");
            Console.WriteLine("Обобщенный класс 1: " + g1);

            GenericClass2<I1_class> g2 = new GenericClass2<I1_class>(new I1_class("Обобщенный класс с ограничением"));
            Console.WriteLine(g2);

            //Вызовы обобщенных методов
            GenericMethod1<I1_class>(new I1_class("Вызов обобщенного метода"));
            GenericMethod2<I1_class, int>(new I1_class("строка"), 333);

            Console.ReadLine();
        }

        /// <summary>
        /// Примеры обобщенных методов
        /// </summary>
        static void GenericMethod1<T>(T param) where T : I1
        {
            Console.WriteLine(param.I1_method());
        }

        static void GenericMethod2<T, Q>(T param1, Q param2)
        {
            Console.WriteLine("Обобщенный метод с двумя типами");
        }
    }

}
