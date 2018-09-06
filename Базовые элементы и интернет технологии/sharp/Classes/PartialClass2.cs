using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Classes
{
    partial class PartialClass
    {
        int i2;

        public override string ToString()
        {
            return "Частичный класс. i1=" + i1.ToString() + " i2=" + i2.ToString();
        }

    }
}
