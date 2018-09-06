using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SimpleListProject
{

    /// <summary>
    /// Пример класса для работы со списком
    /// </summary>
    public class Number : IComparable
    {
        /// <summary>
        /// Целое число
        /// </summary>
        public int Num { get; protected set; }

        /// <summary>
        /// Конструктор
        /// </summary>
        public Number(int param)
        {
            this.Num = param;
        }

        public override string ToString()
        {
            return this.Num.ToString();
        }

        /// <summary>
        /// Реализация интерфейса IComparable
        /// </summary>
        public int CompareTo(object obj)
        {
            Number p = (Number)obj;

            if (this.Num < p.Num) return -1;
            else if (this.Num == p.Num) return 0;
            else return 1; //(this.Num > p.Num)
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            SimpleList<Number> list1 = new SimpleList<Number>();
            list1.Add(new Number(4));
            list1.Add(new Number(2));
            list1.Add(new Number(3));
            list1.Add(new Number(1));

            Console.WriteLine("Обобщенный список");
            foreach (var x in list1) Console.WriteLine(x.Num);

            list1.Sort();
            Console.WriteLine("\nСортировка");
            foreach (var x in list1) Console.WriteLine(x.Num);




            Console.ReadLine();

        }
    }
}
