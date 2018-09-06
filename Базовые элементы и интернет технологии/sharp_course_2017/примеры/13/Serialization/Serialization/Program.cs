using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace Serialization
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
            Console.WriteLine("Бинарная сериализация/десериализация");

            DataBin b = new DataBin
            {
                str1 = "строка1",
                int1 = 333,
                double1 = 123.45
            };

            //+++++++++++++++++
            //сериализация
            //+++++++++++++++++
            Console.WriteLine("До сериализации:");
            Console.WriteLine(b);
            //Текущий каталог
            string currentPath = GetExecPath();
            //Формирование имени файла
            string fileBinName = Path.Combine(currentPath, "file1.bin");
            //При сериализации файл необходимо открыть с использованием потоков
            Stream TestFileStream1 = File.Create(fileBinName);
            //Создание объекта класса сериализации
            BinaryFormatter serializer = new BinaryFormatter();
            //Cериализация объекта в файл
            serializer.Serialize(TestFileStream1, b);
            //Закрытие потока
            TestFileStream1.Close();

            //+++++++++++++++++
            //десериализация 
            //+++++++++++++++++
            //Открытие файла в виде потока на чтение
            Stream TestFileStream2 = File.OpenRead(fileBinName);
            //Десериализация объекта
            DataBin b2 = (DataBin)serializer.Deserialize(TestFileStream2);
            //Закрытие потока
            TestFileStream2.Close();
            Console.WriteLine("После десериализации:");
            Console.WriteLine(b2);

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("Сериализация/десериализация в формате XML:");

            DataXml1 dataXml1 = new DataXml1
            {
                str1 = "строка1 xml",
                int1 = 3333,
                double1 = 333.33
            };

            //+++++++++++++++++
            //сериализация
            //+++++++++++++++++
            Console.WriteLine("До сериализации:");
            Console.WriteLine(dataXml1);
            //Формирование имени файла
            string fileXml1Name = Path.Combine(currentPath, "file2.xml");
            //При сериализации файл необходимо открыть с использованием потоков
            Stream TestFileStream1Xml1 = File.Create(fileXml1Name);
            //Создание объекта класса сериализации
            XmlSerializer serializerXml1 = new XmlSerializer(typeof(DataXml1));
            //Cериализация объекта в файл
            serializerXml1.Serialize(TestFileStream1Xml1, dataXml1);
            //Закрытие потока
            TestFileStream1Xml1.Close();

            //+++++++++++++++++
            //десериализация 
            //+++++++++++++++++
            //Открытие файла в виде потока на чтение
            Stream TestFileStream2Xml1 = File.OpenRead(fileXml1Name);
            //Десериализация объекта
            DataXml1 dataXml1Out = (DataXml1)serializerXml1.Deserialize(TestFileStream2Xml1);
            //Закрытие потока
            TestFileStream2Xml1.Close();
            Console.WriteLine("После десериализации:");
            Console.WriteLine(dataXml1Out);

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("Сериализация/десериализация в формате XML с атрибутами:");

            DataXml2 dataXml2 = new DataXml2
            {
                str1 = "строка1 xml",
                int1 = 3333,
                double1 = 333.33
            };

            //+++++++++++++++++
            //сериализация
            //+++++++++++++++++
            Console.WriteLine("До сериализации:");
            Console.WriteLine(dataXml2);
            //Формирование имени файла
            string fileXml2Name = Path.Combine(currentPath, "file2atr.xml");
            //При сериализации файл необходимо открыть с использованием потоков
            Stream TestFileStream1Xml2 = File.Create(fileXml2Name);
            //Создание объекта класса сериализации
            XmlSerializer serializerXml2 = new XmlSerializer(typeof(DataXml2));
            //Cериализация объекта в файл
            serializerXml2.Serialize(TestFileStream1Xml2, dataXml2);
            //Закрытие потока
            TestFileStream1Xml2.Close();

            //+++++++++++++++++
            //десериализация 
            //+++++++++++++++++
            //Открытие файла в виде потока на чтение
            Stream TestFileStream2Xml2 = File.OpenRead(fileXml2Name);
            //Десериализация объекта
            DataXml2 dataXml2Out = (DataXml2)serializerXml2.Deserialize(TestFileStream2Xml2);
            //Закрытие потока
            TestFileStream2Xml2.Close();
            Console.WriteLine("После десериализации:");
            Console.WriteLine(dataXml2Out);

            Console.ReadLine();
        }
    }
}
