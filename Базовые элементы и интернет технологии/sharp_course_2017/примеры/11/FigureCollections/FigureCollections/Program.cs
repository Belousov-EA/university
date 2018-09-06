using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FigureCollections
{
    class Program
    {
        static void Main(string[] args)
        {
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            //Создание объектов классов фигур:
            Rectangle rect = new Rectangle(5, 4);
            Square square = new Square(5);
            Circle circle = new Circle(5);

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("\nArrayList");
            ArrayList al = new ArrayList();
            al.Add(circle);
            al.Add(rect);
            al.Add(square);

            foreach (var x in al) Console.WriteLine(x);

            Console.WriteLine("\nArrayList - сортировка");
            al.Sort();
            foreach (var x in al) Console.WriteLine(x);

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("\nList<Figure>");
            List<Figure> fl = new List<Figure>();
            fl.Add(circle);
            fl.Add(rect);
            fl.Add(square);

            Console.WriteLine("\nПеред сортировкой:");
            foreach (var x in fl) Console.WriteLine(x);

            //сортировка
            fl.Sort();

            Console.WriteLine("\nПосле сортировки:");
            foreach (var x in fl) Console.WriteLine(x);

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("\nМатрица");
            Matrix<Figure> matrix = new Matrix<Figure>(3, 3, new FigureMatrixCheckEmpty());
            matrix[0, 0] = rect;
            matrix[1, 1] = square;
            matrix[2, 2] = circle;
            Console.WriteLine(matrix.ToString());

            //Выход за границы индекса и обработка исключения
            try
            {
                Figure temp = matrix[123, 123];
            }
            catch (ArgumentOutOfRangeException e)
            {
                Console.WriteLine(e.Message);
            }

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("\nСписок");
            SimpleList<Figure> list = new SimpleList<Figure>();
            list.Add(circle);
            list.Add(rect);
            list.Add(square);
            Console.WriteLine("\nПеред сортировкой:");
            foreach (var x in list) Console.WriteLine(x);
            //сортировка
            list.Sort();
            Console.WriteLine("\nПосле сортировки:");
            foreach (var x in list) Console.WriteLine(x);

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("\nСтек");

            SimpleStack<Figure> stack = new SimpleStack<Figure>();
            //добавление данных в стек
            stack.Push(rect);
            stack.Push(square);
            stack.Push(circle);
            //чтение данных из стека
            while (stack.Count > 0)
            {
                Figure f = stack.Pop();
                Console.WriteLine(f);
            }

            Console.ReadLine();
        }
    }
}
