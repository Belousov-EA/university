using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

//Типы данных - 76

namespace ConsoleInputOutput
{
    class Program
    {
        static void Main(string[] args)
        {
            float f;

            Console.Write("Введите число: ");
            string str = Console.ReadLine();

            //Преобразование строки в число 1
            Console.WriteLine("Преобразование строки в число 1");
            bool ConvertResult = float.TryParse(str, out f);
            if (ConvertResult)
            {
                Console.WriteLine("Вы ввели число " + f.ToString("F5"));
            }
            else
            {
                Console.WriteLine("Вы ввели не число");
            }

            //Преобразование строки в число 2
            Console.WriteLine("Преобразование строки в число 2");
            try
            {
                f = float.Parse(str);
                Console.WriteLine("Вы ввели число " + f.ToString("F5"));
            }
            catch (Exception e)
            {
                Console.WriteLine("Вы ввели не число: " + e.Message);
                Console.WriteLine("\nПодробное описание ошибки: " + e.StackTrace);
            }

            //Вывод параметров командной строки
            CommandLineArgs(args);

            Console.WriteLine("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            double a = ReadDouble("Введите коэффициент А: ");
            Console.WriteLine("Вы ввели коэффициент А = " + a);

            Console.ReadLine();
        }

        /// <summary>
        /// Вывод параметров командной строки
        /// </summary>
        /// <param name="args"></param>
        static void CommandLineArgs(string[] args)
        {

            /*
             Необходимо установить параметры командной строки (несколько слов через пробел)
             в пункте меню "Project", "название проекта Properties"
             вкладка "Debug", поле ввода "Command Line Arguments" 
             */

            //Вывод параметров командной строки 1
            Console.WriteLine("\nВывод параметров командной строки 1:");
            for (int i = 0; i < args.Length; i++)
            {
                Console.WriteLine("Параметр [{0}] = {1}", i, args[i]);
            }

            //Вывод параметров командной строки 2
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
        /// <returns></returns>
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
