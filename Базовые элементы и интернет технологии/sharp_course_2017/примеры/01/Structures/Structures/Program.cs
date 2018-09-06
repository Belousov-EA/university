using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Structures
{
    class Program
    {
        /// <summary>
        /// Использование основных операторов
        /// </summary>
        /// <param name="args"></param>
        static void Main(string[] args)
        {
            string str = "строка1";

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Условия
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            //Условный оператор (в отличие от С++ в условии используется логический тип)
            if (str == "строка1")
            {
                Console.WriteLine("if: str == \"строка1\"");
            }
            else
            {
                Console.WriteLine("if: str != \"строка1\"");
            }

            //Условная операция
            string Result = (str == "строка1" ? "Да" : "Нет");
            Console.WriteLine("?: Равна ли строка '" + str + "' строке 'строка1' - " + Result);

            //Оператор switch
            string Result2 = "";
            switch (str)
            {
                case "строка1":
                    Result2 = "строка1";
                    break;

                case "строка2":
                case "строка3":
                    Result2 = "строка2 или строка3";
                    break;

                default:
                    Result2 = "другая строка";
                    break;
            }
            Console.WriteLine("switch: " + Result2);

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Циклы
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            //Цикл for
            Console.Write("\nЦикл for: ");
            for (int i = 0; i < 3; i++)
                Console.Write(i);

            //Цикл foreach
            Console.Write("\nЦикл foreach: ");
            int[] array1 = { 1, 2, 3 };
            foreach (int i2 in array1)
                Console.Write(i2);

            //Цикл while
            Console.Write("\nЦикл while: ");
            int i3 = 0;
            while (i3 < 3)
            {
                Console.Write(i3);
                i3++;
            }

            //Цикл do while
            Console.Write("\nЦикл do while: ");
            int i4 = 0;
            do
            {
                Console.Write(i4);
                i4++;
            } while (i4 < 3);

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Обработка исключений
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            Console.WriteLine("\n\nДеление на 0:");
            try
            {
                int num1 = 1;
                int num2 = 1;

                string zero = "0";
                int.TryParse(zero, out num2);

                int num3 = num1 / num2;
            }
            catch (DivideByZeroException e)
            {
                Console.WriteLine("Попытка деления на 0");
                Console.WriteLine(e.Message);
            }
            catch (Exception e)
            {
                Console.WriteLine("Собственное исключение");
                Console.WriteLine(e.Message);
            }
            finally
            {
                Console.WriteLine("Это сообщение выводится в блоке finally");
            }


            Console.WriteLine("\nСобственное исключение:");
            try
            {
                throw new Exception("!!! Новое исключение !!!");
            }
            catch (DivideByZeroException e)
            {
                Console.WriteLine("Попытка деления на 0");
                Console.WriteLine(e.Message);
            }
            catch (Exception e)
            {
                Console.WriteLine("Собственное исключение");
                Console.WriteLine(e.Message);
            }
            finally
            {
                Console.WriteLine("Это сообщение выводится в блоке finally");
            }

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Константы
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            const int int_const = 333;

            //Ошибка
            //int_const = 1;

            Console.WriteLine("Константа {0}", int_const);

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Параметры функций
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            //В С# по умолчанию аргументы обычных типов передаются по значению, а объектов по ссылке
            //Аргументы ref всегда передаются по ссылке
            //Аргументы out являются только выходными параметрами 

            string RefTest = "Значение до вызова функций";

            ParamByVal(RefTest);
            Console.WriteLine("\nВызов функции ParamByVal. Значение переменной: " + RefTest);

            ParamByRef(ref RefTest);
            Console.WriteLine("Вызов функции ParamByRef. Значение переменной: " + RefTest);

            int x = 2, x2, x3;
            ParamOut(x, out x2, out x3);
            Console.WriteLine("Вызов функции ParamOut. x={0}, x^2={1}, x^3={2}", x, x2, x3);

            ParamArray("Вывод параметров: ", 1, 2, 333);

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Использование yield
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            Console.Write("\nИспользование yield: ");
            foreach (string st in YieldExample())
                Console.Write(st);


            Console.ReadLine();
        }

        /// <summary>
        /// Передача параметра по значению
        /// </summary>
        /// <param name="param"></param>
        static void ParamByVal(string param)
        {
            param = "Это значение НЕ будет передано в вызывающую функцию";
        }

        /// <summary>
        /// Передача параметра по ссылке
        /// </summary>
        /// <param name="param"></param>
        static void ParamByRef(ref string param)
        {
            param = "Это значение будет передано в вызывающую функцию";
        }

        /// <summary>
        /// Выходные параметры объявляются с помощью out
        /// </summary>
        /// <param name="x"></param>
        /// <param name="x2"></param>
        /// <param name="x3"></param>
        static void ParamOut(int x, out int x2, out int x3)
        {
            x2 = x * x;
            x3 = x * x * x;
        }

        /// <summary>
        /// Переменное количество параметров задается с помощью params
        /// </summary>
        /// <param name="str"></param>
        /// <param name="ArrayParams"></param>
        static void ParamArray(string str, params int[] ArrayParams)
        {
            Console.Write(str);
            foreach (int i in ArrayParams)
                Console.Write(" {0} ", i);
        }

        /// <summary>
        /// Значения, возвращаемые с помощью yield воспринимаются как значения массива
        /// их можно перебирать с помощью foreach
        /// </summary>
        /// <returns></returns>
        static IEnumerable YieldExample()
        {
            yield return "1 ";
            yield return "2 ";
            yield return "333";
        }
    }

}
