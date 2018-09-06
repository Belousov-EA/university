using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events
{
    /// <summary>
    /// Параметры события
    /// </summary>
    public class NewGenericEventArgs : EventArgs
    {
        /// <summary>
        /// Конструктор
        /// </summary>
        public NewGenericEventArgs(string param)
        {
            this.NewGenericEventArgsParam = param;
        }

        /// <summary>
        /// Свойство, содержащее параметр
        /// </summary>
        public string NewGenericEventArgsParam { get; private set; }
    }
}
