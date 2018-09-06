using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Enum2
{
    /// <summary>
    /// Перечисление
    /// </summary>
    public enum СтороныСвета
    {
        Север, Юг, Запад, Восток
    }

    /// <summary>
    /// Перечисление с присвоением значений
    /// </summary>
    public enum СтороныСвета2
    {
        Север = 0, 
        Юг =1, 
        Запад = 3, 
        Восток = 4
    }


    class Program
    {
        static void Main(string[] args)
        {
            СтороныСвета temp1 = СтороныСвета.Восток;
            if (temp1 == СтороныСвета.Восток)
            {
                Console.WriteLine("Восток");
            }

            //Преобразование из строки
            СтороныСвета temp2 = (СтороныСвета)Enum.Parse(typeof(СтороныСвета), "СЕВЕР", true);
            Console.WriteLine(temp2.ToString());

            Console.ReadLine();
        }
    }
}
