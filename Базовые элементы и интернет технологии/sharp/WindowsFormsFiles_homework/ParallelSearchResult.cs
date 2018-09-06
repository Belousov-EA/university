using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsFiles
{
    /// <summary>
    /// Результаты параллельного поиска
    /// </summary>
    public class ParallelSearchResult
    {
        /// <summary>
        /// Найденное слово
        /// </summary>
        public string word { get; set; }

        /// <summary>
        /// Расстояние
        /// </summary>
        public int dist { get; set; }

        /// <summary>
        /// Номер потока
        /// </summary>
        public int ThreadNum { get; set; }
    }
}
