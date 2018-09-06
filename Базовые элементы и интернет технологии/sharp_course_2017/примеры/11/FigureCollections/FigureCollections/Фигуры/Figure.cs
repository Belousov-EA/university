using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FigureCollections
{
    /// <summary>
    /// Класс фигура
    /// </summary>
    abstract class Figure : IComparable
    {
        /// <summary>
        /// Тип фигуры
        /// </summary>
        public string Type
        {
            get
            {
                return this._Type;
            }
            protected set
            {
                this._Type = value;
            }
        }
        string _Type;

        /// <summary>
        /// Вычисление площади
        /// </summary>
        /// <returns></returns>
        public abstract double Area();

        /// <summary>
        /// Приведение к строке, переопределение метода Object
        /// </summary>
        /// <returns></returns>
        public override string ToString()
        {
            return this.Type + " площадью " + this.Area().ToString();
        }

        /// <summary>
        /// Сравнение элементов (для сортировки)
        /// this - левый параметр сравнения
        /// </summary>
        /// <param name="obj">правый параметр сравнения</param>
        /// <returns>
        /// -1 - если левый параметр меньше правого
        /// 0 - параметры равны
        /// 1 - правый параметр меньше левого
        /// </returns>
        public int CompareTo(object obj)
        {
            //Приведение параметра к типу "фигура"
            Figure p = (Figure)obj;
            //Сравнение
            if (this.Area() < p.Area()) return -1;
            else if (this.Area() == p.Area()) return 0;
            else return 1; //(this.Area() > p.Area())
        }
    }
}
