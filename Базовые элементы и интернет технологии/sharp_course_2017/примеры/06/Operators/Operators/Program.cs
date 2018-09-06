using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Operators
{
    class Program
    {
        static void Main(string[] args)
        {
            Number a = new Number(1);

            Console.WriteLine("\nУнарный оператор");

            a++;
            Console.WriteLine("a={0}", a);

            ++a;
            Console.WriteLine("a={0}", a);

            Console.WriteLine("\nБинарный оператор");
            Number b = new Number(100);

            Number c = a + b;
            Console.WriteLine("c={0}", c);

            int i = 333;
            Number d = a + i;
            Console.WriteLine("d={0}", d);

            //Ошибка, так как не перегружен оператор (int + Number)
            //Number d1 = i + d;

            //При перегрузке операторов как правило создается новый объект
            //Если он создается многократно, то на вызов конструктора может уходить много времени

            //Если перегрузка оператора вызывется вместо вызова метода, который изменяет состояние объекта
            //то из-за дополнительного вызова конструктора перегрузка оператора может работать медленнее, чем вызов метода
            Number e = new Number(1);

            Console.WriteLine("\nАналог \"внутренней перегрузки\" в С++");
            e.AddInt(1);
            Console.WriteLine("e={0}", e);

            Console.WriteLine("\nАналог \"внешней перегрузки\" в С++");
            e = e + 1;
            Console.WriteLine("e={0}", e);

            Console.WriteLine("\nАналог \"внутренней перегрузки\" оператора *");
            Number mul1 = new Number(5);
            Number mul2 = mul1 * 4;
            Console.WriteLine("mul1={0}", mul1);
            Console.WriteLine("mul2={0}", mul2);

            Console.WriteLine("\nПерегрузка операторов сравнения");
            Number eq1 = new Number(3);
            Number eq2 = new Number(2);

            Console.WriteLine("{0} == {1} ---> {2}", eq1, eq2, (eq1 == eq2));
            Console.WriteLine("{0} != {1} ---> {2}", eq1, eq2, (eq1 != eq2));
            Console.WriteLine("{0} > {1} ---> {2}", eq1, eq2, (eq1 > eq2));
            Console.WriteLine("{0} < {1} ---> {2}", eq1, eq2, (eq1 < eq2));
            Console.WriteLine("{0} >= {1} ---> {2}", eq1, eq2, (eq1 >= eq2));
            Console.WriteLine("{0} <= {1} ---> {2}", eq1, eq2, (eq1 <= eq2));

            Console.WriteLine("\nОператоры приведения типов");

            Console.WriteLine("Явное приведение типов");
            int intEq1 = (int)eq1;
            Console.WriteLine("{0} ---> {1}", eq1, intEq1);

            Console.WriteLine("Неявное приведение типов");
            double doubleEq1 = eq1;
            Console.WriteLine("{0} ---> {1}", eq1, doubleEq1);

            Console.WriteLine("\nИндексатор");
            Number index = new Number(1);
            index[330] = 3;
            Console.WriteLine("index[{0}] = {1}", 0, index[0]);

            Console.ReadLine();

        }
    }

}
