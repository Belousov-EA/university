using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

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
        /// <param name="param"></param>
        public NewGenericEventArgs(string param)
        {
            this.NewGenericEventArgsParam = param;
        }

        /// <summary>
        /// Свойство, содержащее параметр
        /// </summary>
        public string NewGenericEventArgsParam { get; private set; }
    }

    /// <summary>
    /// Издатель события
    /// </summary>
    public class NewGenericEventPublisher
    {
        /// <summary>
        /// Событие создается через обобщенный делегат
        /// </summary>
        public event EventHandler<NewGenericEventArgs> NewGenericEvent;

        /// <summary>
        /// Свойство, содержащее параметр
        /// </summary>
        public string NewGenericEventArgsParam { get; private set; }

        /// <summary>
        /// Конструктор
        /// </summary>
        /// <param name="param"></param>
        public NewGenericEventPublisher(string param)
        {
            this.NewGenericEventArgsParam = param;
        }
        
        public void RaiseNewGenericEvent()
        {
            //Если у события есть подписчики
            if (NewGenericEvent != null)
            {
                //Запуск события
                NewGenericEvent(this, new NewGenericEventArgs(this.NewGenericEventArgsParam));
            }
        }
    }
}
