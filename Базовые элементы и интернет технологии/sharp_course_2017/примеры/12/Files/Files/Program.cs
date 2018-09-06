using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Files
{
    class Program
    {
        /// <summary>
        /// Возвращает путь к текущему исполняемому файлу
        /// </summary>
        static string GetExecPath()
        {
            //Получение пути и имени текущего исполняемого файла с помощью механизма рефлексии
            string exeFileName = System.Reflection.Assembly.GetExecutingAssembly().Location;
            //Получение пути к текущему исполняемому файлу
            string Result = Path.GetDirectoryName(exeFileName);
            return Result;
        }

        static void Main(string[] args)
        {
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            //Работа с файловой системой
            string catalogName = @"c:\";
            Console.WriteLine("\nСписок файлов каталога " + catalogName);
            string[] files = Directory.GetFiles(catalogName);
            foreach (string file in files)
            {
                Console.WriteLine(file);
            }

            Console.WriteLine("\nСписок подкаталогов каталога " + catalogName);
            string[] dirs = Directory.GetDirectories(catalogName);
            foreach (string dir in dirs)
            {
                Console.WriteLine(dir);
            }

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            //Работа с текстовыми файлами

            //Текущий каталог
            string currentPath = GetExecPath();
            Console.Write("Введите текст для записи в файл:");
            //Ввод содержимого файла
            string file1Contents = Console.ReadLine();
            //Формирование имени файла
            string file1Name = Path.Combine(currentPath, "file1.txt");
            //Запись строки в файл
            File.WriteAllText(file1Name, file1Contents);
            //Чтение строки из файла
            string file1ContentsRead = File.ReadAllText(file1Name);
            Console.Write("Чтение строки из файла:");
            Console.WriteLine(file1ContentsRead);

            Console.WriteLine("Введите строки для записи в файл (пустая строка - окончание ввода):");
            string tempStrTrim = "";
            //Список строк
            List<string> list = new List<string>();
            do
            {
                //Временная переменная для хранения строки
                string tempStr = Console.ReadLine();
                //Удаление пробелов из введенной строки
                tempStrTrim = tempStr.Trim();
                if (tempStrTrim != "")
                {
                    //Непустая строка сохраняется в список
                    list.Add(tempStrTrim);
                }
            }
            while (tempStrTrim != "");

            //Формирование имени файла
            string file2Name = Path.Combine(currentPath, "file2.txt");
            //Запись в файл массива строк
            File.WriteAllLines(file2Name, list.ToArray());

            //Чтение строк из файла
            string[] file2ContentsRead = File.ReadAllLines(file2Name);
            Console.WriteLine("Чтение строк из файла:");
            foreach (string str in file2ContentsRead)
            {
                Console.WriteLine(str);
            }

            Console.ReadLine();
        }
    }
}
