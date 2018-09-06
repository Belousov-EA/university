using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsFiles
{
    /// <summary>
    /// Хранение минимального и максимального значений
    /// </summary>
    public struct MinMax
    {
        public int Min;
        public int Max;

        public MinMax(int pmin, int pmax)
        {
            this.Min = pmin;
            this.Max = pmax;
        }
    }

    /// <summary>
    /// Деление последовательности на подпоследовательности 
    /// Индекс в массиве делится для параллельного запуска в потоках
    /// </summary>
    public static class SubArrays
    {
        /// <summary>
        /// Деление массива на подпоследовательности
        /// </summary>
        /// <param name="beginIndex"></param>
        /// <param name="endIndex"></param>
        /// <param name="subArraysCount"></param>
        /// <returns></returns>
        public static List<MinMax> DivideSubArrays(int beginIndex, int endIndex, int subArraysCount)
        {
            List<MinMax> result = new List<MinMax>();

            if ((endIndex - beginIndex) <= subArraysCount)
            {
                result.Add(new MinMax(0, (endIndex - beginIndex)));
            }
            else
            {
                int delta = (endIndex - beginIndex) / subArraysCount;
                int currentBegin = beginIndex;

                while ((endIndex - currentBegin) >= 2 * delta)
                {
                    result.Add(new MinMax(currentBegin, currentBegin + delta));
                    currentBegin += delta;
                }
                result.Add(new MinMax(currentBegin, endIndex));
            }
            return result;
        }
    }
}
