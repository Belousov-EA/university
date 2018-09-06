using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events
{
    //Объявление делегата для события (в пространстве имен, вне класса)
    public delegate void NewEventDelegate(string str);

    class Program
    {
        //Объявление события (внутри класса)
        public static event NewEventDelegate NewEvent;

        public static void EventHandler1(string str)
        {
            Console.WriteLine("Первый обработчик события: " + str);
        }

        public static void EventHandler2(string str)
        {
            Console.WriteLine("Второй обработчик события: " + str);
        }


        static void Main(string[] args)
        {
            //Вызов события производится по названию события как процедуры
            //Этот вызов не сработает, так как не прикреплены обработчики события
            //NewEvent != null - проверка того, что к событию прикреплены обработчики 
            if (NewEvent != null) NewEvent("вызов события 0");

            //Прикрепление обработчика события
            Program.NewEvent += EventHandler1;
            if (Program.NewEvent != null) Program.NewEvent("вызов события 1");

            //Прикрепление второго обработчика события
            //Вызываются оба обработчика
            Program.NewEvent += EventHandler2;
            if (Program.NewEvent != null) Program.NewEvent("вызов события 2");

            //Удаление второго обработчика события
            Program.NewEvent -= EventHandler2;
            if (Program.NewEvent != null) Program.NewEvent("вызов события 3");


            /////////////////////////////////////////////////////////
            //Подписка на событие, определенное через обобщенный делегат
            NewGenericEventPublisher ne = new NewGenericEventPublisher();

            //Обработчик события задается как лябда-выражение, хотя может быть определен как обычный метод
            ne.NewGenericEvent += new EventHandler<NewGenericEventArgs>(
                (sender, e) =>
                {
                    Console.WriteLine(e.NewGenericEventArgsParam);
                }
                );

            //Вызов события
            ne.RaiseNewGenericEvent("Событие NewGenericEventPublisher");

            Console.ReadLine();
        }
    }

}
