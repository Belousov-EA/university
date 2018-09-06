using System;
using System.Xml.Serialization;

namespace Serialization
{
    [XmlRoot(ElementName = "DataXmlWithParameters")]
    public class DataXml2
    {
        [XmlIgnore]
        public int int1 { get; set; }
        [XmlAttribute(AttributeName = "DoubleParameter")]
        public double double1 { get; set; }
        [XmlElement(ElementName = "StringParameter")]
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
