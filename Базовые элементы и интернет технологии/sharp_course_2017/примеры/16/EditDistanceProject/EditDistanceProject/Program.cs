using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditDistanceProject
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Добавление одного символа в начало середину и конец строки");
            EditDistance.WriteDistance("пример", "1пример");
            EditDistance.WriteDistance("пример", "при1мер");
            EditDistance.WriteDistance("пример", "пример1");

            Console.WriteLine("Добавление двух символов в начало середину и конец строки");
            EditDistance.WriteDistance("пример", "12пример");
            EditDistance.WriteDistance("пример", "при12мер");
            EditDistance.WriteDistance("пример", "пример12");

            Console.WriteLine("Добавление трех символов");
            EditDistance.WriteDistance("пример", "1при2мер3");

            Console.WriteLine("Транспозиция");
            EditDistance.WriteDistance("прИМер", "прМИер");

            Console.WriteLine("Рассмотренный ранее пример");
            EditDistance.WriteDistance("ИВАНОВ", "БАННВО");

            Console.ReadLine();
        }
    }
}
