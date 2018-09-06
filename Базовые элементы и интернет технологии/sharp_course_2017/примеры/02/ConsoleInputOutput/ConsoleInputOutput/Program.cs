using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleInputOutput
{
    class Program
    {
        static void Main(string[] args)
        {
            double d;

            Console.Write("Введите число: ");
            string str = Console.ReadLine();

            //Преобразование строки в число - вариант 1
            Console.WriteLine("Преобразование строки в число 1");
            bool ConvertResult = double.TryParse(str, out d);
            if (ConvertResult)
            {
                Console.WriteLine("Вы ввели число " + d.ToString("F5"));
            }
            else
            {
                Console.WriteLine("Вы ввели не число");
            }

            //Преобразование строки в число - вариант 2
            Console.WriteLine("Преобразование строки в число 2");
            try
            {
                d = double.Parse(str);
                Console.WriteLine("Вы ввели число " + d.ToString("F5"));
            }
            catch (Exception e)
            {
                Console.WriteLine("Вы ввели не число: " + e.Message);
                Console.WriteLine("\nПодробное описание ошибки: " + e.StackTrace);
            }

            //Преобразование строки в число - вариант 3
            Console.WriteLine("Преобразование строки в число 3");
            try
            {
                d = Convert.ToDouble(str);
                Console.WriteLine("Вы ввели число " + d.ToString("F5"));
            }
            catch (Exception e)
            {
                Console.WriteLine("Вы ввели не число: " + e.Message);
                Console.WriteLine("\nПодробное описание ошибки: " + e.StackTrace);
            }

            //Вывод параметров командной строки
            CommandLineArgs(args);

            double a = ReadDouble("Введите коэффициент: ");
            Console.WriteLine("Вы ввели коэффициент = " + a);

            Console.ReadLine();
        }

        /// <summary>
        /// Вывод параметров командной строки
        /// </summary>
        static void CommandLineArgs(string[] args)
        {

            /*
             Необходимо установить параметры командной строки (несколько слов через пробел)
             в пункте меню "Project", "название проекта Properties"
             вкладка "Debug", поле ввода "Command Line Arguments" 
             */

            //Вывод параметров командной строки - вариант 1
            Console.WriteLine("\nВывод параметров командной строки 1:");
            for (int i = 0; i < args.Length; i++)
            {
                Console.WriteLine("Параметр [{0}] = {1}", i, args[i]);
            }

            //Вывод параметров командной строки - вариант 2
            Console.WriteLine("\nВывод параметров командной строки 2:");
            int i2 = 0;
            foreach (string param in args)
            {
                Console.WriteLine("Параметр [{0:F5}] = {1}", i2, param);
                i2++;
            }
        }

        /// <summary>
        /// Ввод вещественного числа с проверкой корректности ввода
        /// </summary>
        /// <param name="message">Подсказка при вводе</param>
        static double ReadDouble(string message)
        {
            string resultString;
            double resultDouble;
            bool flag;

            do
            {
                Console.Write(message);
                resultString = Console.ReadLine();

                //Первый способ преобразования строки в число
                flag = double.TryParse(resultString, out resultDouble);

                //Второй способ преобразования строки в число
                /* 
                try
                {
                    resultDouble = double.Parse(resultString);
                    //resultDouble = Convert.ToDouble(resultString);
                    flag = true;
                }
                catch
                {
                    //Необходимо присвоить значение по умолчанию из-за ошибки компилятора
                    resultDouble = 0;
                    flag = false;
                }
                */

                if (!flag)
                {
                    Console.WriteLine("Необходимо ввести вещественное число");
                }
            }
            while (!flag);

            return resultDouble;
        }

    }
}
