using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Classes
{
    //partial - объявление частичного класса
    partial class PartialClass
    {
        int i1;

        public PartialClass(int pi1, int pi2) { i1 = pi1; i2 = pi2; }

        public int MethodPart1(int i1, int i2)
        {
            return i1 + i2;
        }
    }
}
