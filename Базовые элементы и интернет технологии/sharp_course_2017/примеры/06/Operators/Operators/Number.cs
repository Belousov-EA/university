using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Operators
{
    /// <summary>
    /// Пример класса для перегрузки операторов
    /// </summary>
    public class Number
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
            Console.WriteLine("Вызов конструктора для {0}", param);
        }

        /// <summary>
        /// Приведение к строке
        /// </summary>
        public override string ToString()
        {
            return this.Num.ToString();
        }

        //lhs - left hand side
        //rhs - right hand side

        /// <summary>
        /// Перегрузка унарного оператора 
        /// Префиксную и постфиксную формы компилятор различет автоматически
        /// </summary>
        /// <param name="lhs"></param>
        /// <returns></returns>
        public static Number operator ++(Number lhs)
        {
            //Не нужно изменять вызываемый объект
            //lhs.Num++;
            //return lhs;

            return new Number(lhs.Num + 1);
        }

        /// <summary>
        /// Перегрузка бинарного оператора для (Number + Number)
        /// </summary>
        public static Number operator +(Number lhs, Number rhs)
        {
            int newNum = lhs.Num + rhs.Num;
            Number Result = new Number(newNum);
            return Result;

            //return new Number(lhs.Num + rhs.Num);
        }

        /// <summary>
        /// Перегрузка бинарного оператора для (Number + int)
        /// </summary>
        public static Number operator +(Number lhs, int rhs)
        {
            return new Number(lhs.Num + rhs);
        }

        /// <summary>
        /// Метод как аналог внутренней перегрузки
        /// </summary>
        public void AddInt(int param)
        {
            this.Num += param;
        }

        /// <summary>
        /// Аналог внутренней перегрузки
        /// без создания нового объекта
        /// </summary>
        public static Number operator *(Number lhs, int rhs)
        {
            lhs.Num = lhs.Num * rhs;
            return lhs;
        }


        //Перегрузка операторов сравнения должна производиться попарно
        // == и !=
        // > и <
        // => и <=

        public static bool operator ==(Number lhs, Number rhs)
        {
            return lhs.Num == rhs.Num;
        }

        public static bool operator !=(Number lhs, Number rhs)
        {
            return !(lhs == rhs);
        }


        //Если переопределяется оператор ==, то необходимо перегрузить следующие методы
        //компилятор выдает не ошибку а предупреждение
        public override bool Equals(object obj)
        {
            Number param = (Number)obj;
            return this == param;
        }

        public override int GetHashCode()
        {
            return this.Num.GetHashCode();
        }

        //Перегрузка операторов неравенства

        public static bool operator <(Number lhs, Number rhs)
        {
            return lhs.Num < rhs.Num;
        }
        public static bool operator >(Number lhs, Number rhs)
        {
            return lhs.Num > rhs.Num;
        }

        public static bool operator <=(Number lhs, Number rhs)
        {
            return lhs.Num <= rhs.Num;
        }
        public static bool operator >=(Number lhs, Number rhs)
        {
            return lhs.Num >= rhs.Num;
        }


        //Операторы приведения типов
        //Для одного типа можно задать или явное или неявное приведение

        /// <summary>
        /// Оператор явного приведения типа Number к типу int
        /// </summary>
        public static explicit operator int(Number lhs)
        {
            return lhs.Num;
        }

        /// <summary>
        /// Оператор неявного приведения типа Number к типу double
        /// </summary>
        public static implicit operator double(Number lhs)
        {
            return (double)lhs.Num;
        }

        /// <summary>
        /// Пример индексатора
        /// </summary>
        public int this[int i]
        {
            get
            {
                //Возможный доступ к i-му элементу встроенного массива
                return this.Num + i;
            }
            set
            {
                //Возможный доступ к i-му элементу встроенного массива
                this.Num = value + i;
            }
        }
    }
}
