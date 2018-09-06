using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Classes
{
    /// <summary>
    /// Базовый класс
    /// </summary>
    class BaseClass
    {
        private int i;

        //Конструктор
        public BaseClass(int param) { i = param; }
        //Методы с различными сигнатурами
        public int MethodReturn(int a) { return i; }
        public string MethodReturn(string a) { return i.ToString(); }

        //Свойство
        //private-значение, которое хранит данные для свойства
        private int _property1 = 0;
        //объявление свойства
        public int property1
        {
            //возвращаемое значение
            get { return _property1; }
            //установка значения, value - ключевое слово
            set { _property1 = value; }
            //private set { _property1 = value; }
        }

        /// <summary>
        /// Вычисляемое свойство
        /// </summary>
        public int property1mul2
        {
            get { return property1 * 2; }
        }

        //Автоматически реализуемые свойства
        //поддерживающая переменная создается автоматически
        public string property2 { get; set; }
        public float property3 { get; private set; }

    }

    /// <summary>
    /// Наследуемый класс 1
    /// </summary>
    class ExtendedClass1 : BaseClass
    {
        private int i2;
        private int i3;

        //Конструктор
        //base(pi) - вызов конструктора базового класса
        public ExtendedClass1(int pi, int pi2) : base(pi) { i2 = pi2; }

        //this(pi, pi2) - вызов другого конструктора этого класса
        public ExtendedClass1(int pi, int pi2, int pi3) : this(pi, pi2) { i3 = pi3; }

        /// <summary>
        /// Метод виртуальный, так как он объявлен в самом базовом классе object
        /// поэтому чтобы его переопределить добавлено ключевое слово override
        /// </summary>
        /// <returns></returns>
        public override string ToString()
        {
            return "i=" + MethodReturn("1") + " i2=" + i2.ToString() + " i3=" + i3.ToString();
        }

    }

    /// <summary>
    /// Объявление интерфейсов для множественного наследования
    /// </summary>
    interface I1
    {
        string I1_method();
    }

    interface I2 : I1
    {
        string I2_method();
    }


    /// <summary>
    /// Наследуемый класс 2
    /// </summary>
    class ExtendedClass2 : ExtendedClass1, I1, I2
    {
        //В конструкторе вызывается конструктор базового класса
        public ExtendedClass2(int pi, int pi2, int pi3) : base(pi, pi2, pi3) { }

        //Реализация методов, объявленных в интерфейсах
        public string I1_method() { return ToString(); }
        public string I2_method() { return ToString(); }
    }

    /// <summary>
    /// Метод расширения
    /// </summary>
    static class ExtendedClass2Extension
    {
        public static int ExtendedClass2NewMethod(this ExtendedClass2 ec2, int i)
        {
            return i + 1;
        }
    }

    /// <summary>
    /// Основной класс
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Базовый класс");

            //Объект базового класса
            BaseClass bc = new BaseClass(333);
            Console.WriteLine(bc.MethodReturn(1));
            Console.WriteLine(bc.MethodReturn("1"));

            //Обращение к свойству
            bc.property1 = 334;
            Console.WriteLine("\n property1 = {0}", bc.property1);

            Console.WriteLine("\nНаследуемый класс 1");
            //Объекты наследуемого класса
            ExtendedClass1 ex1_1 = new ExtendedClass1(1, 2);
            //Неявно вызывается метод ex1.ToString()
            Console.WriteLine(ex1_1);

            ExtendedClass1 ex1_2 = new ExtendedClass1(1, 2, 3);
            Console.WriteLine(ex1_2);

            Console.WriteLine("\nНаследуемый класс 2");


            ExtendedClass2 ex2 = new ExtendedClass2(100, 200, 300);
            Console.WriteLine(ex2.I1_method());
            Console.WriteLine(ex2.I2_method());
            Console.WriteLine(ex2.ExtendedClass2NewMethod(332));

            Console.WriteLine("\nЧастичный класс");
            PartialClass part = new PartialClass(333, 334);
            Console.WriteLine(part);
            Console.WriteLine("\nИспользование рефлексии");
            Console.WriteLine("Список методов класса ExtendedClass2:");
            foreach (System.Reflection.MemberInfo member in ex2.GetType().GetMethods())
            {
                Console.WriteLine(member.Name);
            }

            Rectangle rect = new Rectangle(5, 4);
            rect.Print();

            Console.ReadLine();
        }
    }
}
