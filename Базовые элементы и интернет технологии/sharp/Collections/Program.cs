using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Collections
{
    class Program
    {
        static void Main(string[] args)
        {

            //////////////////////////////////////////////
            //Типы коллекций
            //Книга от сертификационного экзамена
            //стр. 228
            //////////////////////////////////////////////

            //Работа со списками
            Console.WriteLine("Список:");
            ArrayList al = new ArrayList();
            al.Add(333);
            al.Add(123.123);
            al.Add("строка");

            foreach (object o in al)
            {
                //Для определения типа используется механизм рефлексии
                string type = o.GetType().Name;
                if (type == "Int32")
                {
                    Console.WriteLine("Целое число: " + o.ToString());
                }
                else if (type == "String")
                {
                    Console.WriteLine("Строка: " + o.ToString());
                }
                else
                {
                    Console.WriteLine("Другой тип: " + o.ToString());
                }
            }

            Console.WriteLine("\nОбобщенный (generic) список: ");
            List<int> li = new List<int>();
            li.Add(1);
            li.Add(2);
            li.Add(3);
            foreach(int i in li) Console.WriteLine(i);

            Console.WriteLine("\nОбобщенный (generic) словарь (ассоциативный массив): ");
            Dictionary<int, string> d = new Dictionary<int, string>();
            d.Add(1, "строка 1");
            d.Add(2, "строка 2");
            d.Add(4, "строка 4");
            d.Add(3, "строка 3");
            d.Remove(4);

            foreach (KeyValuePair<int, string> v in d)
                Console.WriteLine(v.Key.ToString() + " --> " + v.Value);

            Console.Write("\nКлючи: ");
            foreach (int i in d.Keys) Console.Write(i.ToString() + " ");

            Console.Write("\nЗначения: ");
            foreach (string str in d.Values) Console.Write(str + " ");

            int key = 3;
            string val = "";
            d.TryGetValue(3, out val);
            Console.WriteLine("\nДля ключа '" + key.ToString() + "' значение '" + val + "'");


            Console.WriteLine("\nКортежи");
            Tuple<int, string, string> group = new Tuple<int, string, string>(1, "ИУ", "ИУ-5");
            Console.WriteLine(group.ToString());
            
            //Класс позволяет определять до 8 параметров,
            //если нужно большее количество используется следующее объявление
            Tuple<int, int, int, int, int, int, int, Tuple<string, string, string>> tuple = new Tuple<int, int, int, int, int, int, int, Tuple<string, string, string>>(1, 2, 3, 4, 5, 6, 7, new Tuple<string, string, string>("str1", "str2", "str3"));
            Console.WriteLine(tuple.ToString());

            List<Tuple<int, int, int>> tupleList = new List<Tuple<int, int, int>>();
            tupleList.Add(new Tuple<int, int, int>(1, 1, 1));
            tupleList.Add(new Tuple<int, int, int>(2, 2, 2));
            tupleList.Add(new Tuple<int, int, int>(3, 3, 3));

            foreach (var x in tupleList) Console.WriteLine(x);

            ////////////////////////////////////////
            //стр.328 - оценка производительности
            ////////////////////////////////////////

            Console.ReadLine();
        }
    }
}
