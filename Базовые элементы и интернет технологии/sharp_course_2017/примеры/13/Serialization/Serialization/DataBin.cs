using System;

namespace Serialization
{
    [Serializable]
    class DataBin
    {
        public int int1 { get; set; }
        public double double1 { get; set; }
        public string str1 { get; set; }

        public override string ToString()
        {
            return
                "str1=" + str1
                + " int1=" + int1.ToString()
                + " double1=" + double1.ToString();
        }
    }
}