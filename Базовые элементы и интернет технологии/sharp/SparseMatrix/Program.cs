using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SparseMatrix
{
    class Program
    {
        static void Main(string[] args)
        {
            Matrix<int> x = new Matrix<int>(4, 3, -1);
            x[0, 0] = 333;
            x[1, 1] = 334;

            try
            {
                x[100, 100] = 100;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            Console.WriteLine(x);

            Console.ReadLine();
        }
    }
}
