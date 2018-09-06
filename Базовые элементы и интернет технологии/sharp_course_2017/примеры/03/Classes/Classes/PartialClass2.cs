using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Classes
{
    partial class PartialClass
    {
        int i2;

        public override string ToString()
        {
            return "Частичный класс. i1=" + i1.ToString()
                                 + " i2=" + i2.ToString();
        }

        public string MethodPart2(string i1, string i2)
        {
            return i1 + i2;
        }
    }
}
