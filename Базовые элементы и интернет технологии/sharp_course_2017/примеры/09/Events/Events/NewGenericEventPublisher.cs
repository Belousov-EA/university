using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events
{
    /// <summary>
    /// Класс, содержащий событие
    /// </summary>
    public class NewGenericEventPublisher
    {
        /// <summary>
        /// Событие создается через обобщенный делегат
        /// </summary>
        public event EventHandler<NewGenericEventArgs> NewGenericEvent;

        /// <summary>
        /// Вызов события
        /// </summary>
        public void RaiseNewGenericEvent(string param)
        {
            //Если у события есть подписчики
            if (NewGenericEvent != null)
            {
                //Вызов события
                NewGenericEvent(this, new NewGenericEventArgs(param));
            }
        }
    }
}
