using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Collections
{
    class Program
    {
        static void Main(string[] args)
        {
            //Работа с обобщенным списком
            Console.WriteLine("\nОбобщенный (generic) список: ");
            List<int> li = new List<int>();
            li.Add(1);
            li.Add(2);
            li.Add(3);
            foreach (int i in li)
            {
                Console.WriteLine(i);
            }

            int item2 = li[1];
            int count = li.Count;
            bool is3 = li.Contains(3);
            li.Remove(2);

            //Работа с необобщенным списком
            Console.WriteLine("\nНеобобщенный список:");
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

            //Работа со стеком
            Console.WriteLine("\nСтек:");
            Stack<int> st = new Stack<int>();
            st.Push(1);
            st.Push(2);
            st.Push(3);

            Console.WriteLine("\nПеребор элементов стека с помощью foreach:");
            foreach (int i in st)
            {
                Console.WriteLine(i);
            }

            Console.Write("\nПолучение верхнего элемента без удаления:");
            int i2 = st.Peek();
            Console.WriteLine(i2);

            Console.WriteLine("\nЧтение с удалением элементов из стека:");
            while (st.Count > 0)
            {
                int i = st.Pop();
                Console.WriteLine(i);
            }

            //Работа с очередью
            Console.WriteLine("\nОчередь:");
            Queue<int> q = new Queue<int>();
            q.Enqueue(11);
            q.Enqueue(22);
            q.Enqueue(33);

            Console.WriteLine("\nПеребор элементов очереди с помощью foreach:");
            foreach (int i in q)
            {
                Console.WriteLine(i);
            }

            Console.Write("\nПолучение первого элемента без удаления:");
            int i3 = q.Peek();
            Console.WriteLine(i3);

            Console.WriteLine("\nЧтение с удалением элементов из очереди:");
            while (q.Count > 0)
            {
                int i = q.Dequeue();
                Console.WriteLine(i);
            }

            //Работа с обобщенным словарем
            Console.WriteLine("\nОбобщенный (generic) словарь (ассоциативный массив): ");
            Dictionary<int, string> d = new Dictionary<int, string>();
            d.Add(1, "строка 1");
            d.Add(2, "строка 2");
            d.Add(4, "строка 4");
            d.Add(3, "строка 3");
            d.Remove(4);

            foreach (KeyValuePair<int, string> v in d)
            {
                Console.WriteLine(v.Key.ToString() + "-" + v.Value);
            }

            Console.Write("\nКлючи: ");
            foreach (int i in d.Keys)
            {
                Console.Write(i.ToString() + " ");
            }

            Console.Write("\nЗначения: ");
            foreach (string str in d.Values)
            {
                Console.Write(str + " ");
            }

            int key = 3;
            string val = d[key];
            Console.WriteLine("\nДля ключа '" + key.ToString() + "' значение '" + val + "'");

            string val2 = "";
            bool res = d.TryGetValue(key, out val2);
            if (res)
            {
                Console.WriteLine("\nДля ключа '" + key.ToString() + "' значение '" + val2 + "'");
            }


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

            Console.WriteLine("\nСортировка списка целых чисел:");
            List<int> sl = new List<int>();
            sl.Add(5);
            sl.Add(3);
            sl.Add(2);
            sl.Add(1);
            sl.Add(4);
            Console.WriteLine("\nПеред сортировкой:");
            foreach (int i in sl) Console.Write(i.ToString() + " ");

            //Сортировка
            sl.Sort();

            Console.WriteLine("\nПосле сортировки:");
            foreach (int i in sl) Console.Write(i.ToString() + " ");

            Console.ReadLine();
        }
    }
}
