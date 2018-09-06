using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using SimpleListProject;

namespace FigureCollections
{
    class SimpleStack<T> : SimpleList<T> where T : IComparable
    {

        /// <summary>
        /// Добавление в стэк
        /// </summary>
        /// <param name="element"></param>
        public void Push(T element)
        {
            //Добавление в конец списка уже реализовано 
            Add(element);
        }

        /// <summary>
        /// Удаление и чтение из стека
        /// </summary>
        public T Pop()
        {
            //default(T) - значение для типа T по умолчанию
            T Result = default(T);

            if (this.Count == 0) return Result;
            
            //Если элемент единственный
            if (this.Count == 1)
            {
                //то из него читаются данные
                Result = this.first.data;
                this.first = null;
                this.last = null;
            }
            else
            {
                //В списке более одного элемента

                //Поиск предпоследнего элемента
                SimpleListItem<T> newLast = this.GetItem(this.Count - 2);
                //Чтение значения из последнего элемента
                Result = newLast.next.data;
                //предпоследний элемент считается последним
                this.last = newLast;
                //последний элемент удаляется из списка
                newLast.next = null;
            }

            //Уменьшение количества элементов в списке
            this.Count--;
            
            return Result;
        }

    }
}
