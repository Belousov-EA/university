using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Classes
{
    //partial - объявление частичного класса
    partial class PartialClass
    {
        int i1;

        public PartialClass(int pi1, int pi2) { i1 = pi1; i2 = pi2; }
    }
}
