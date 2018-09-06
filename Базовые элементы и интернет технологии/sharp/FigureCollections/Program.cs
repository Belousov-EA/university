using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace FigureCollections
{
    class Program
    {
        static void Main(string[] args)
        {
            //+++++++++++++++++++++++++++++++++++++++++++++++++
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

            foreach (var x in fl) Console.WriteLine(x);

            Console.WriteLine("\nList<Figure> - сортировка");
            fl.Sort();
            foreach (var x in fl) Console.WriteLine(x);

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("\nМатрица");
            Matrix3D<Figure> cube = new Matrix3D<Figure>(3, 3, 3, null);
            cube[0, 0, 0] = rect;
            cube[1, 1, 1] = square;
            cube[2, 2, 2] = circle;
            Console.WriteLine(cube.ToString());

            //+++++++++++++++++++++++++++++++++++++++++++++++++
            Console.WriteLine("\nСтек");
            SimpleStack<Figure> stack = new SimpleStack<Figure>();
            stack.Push(rect);
            stack.Push(square);
            stack.Push(circle);

            while (stack.Count > 0)
            {
                Figure f = stack.Pop();
                Console.WriteLine(f);
            }

            Console.ReadLine();
        }
    }
}
