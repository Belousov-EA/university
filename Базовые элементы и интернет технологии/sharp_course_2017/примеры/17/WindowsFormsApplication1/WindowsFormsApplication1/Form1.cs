using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Текущее состояние таймера
        /// </summary>
        TimeSpan currentTimer = new TimeSpan();

        /// <summary>
        /// Обновление текущего состояния таймера
        /// </summary>
        private void RefreshTimer()
        {
            //Обновление поля таймера в форме
            textTimer.Text = currentTimer.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //Запись текста в текстовое поле
            textBox1.Text = "Кнопка нажата";
            //Окно сообщения
            MessageBox.Show("Кнопка нажата");
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            //Добавление к текущему состоянию таймера 
            //интервала в одну секунду 
            currentTimer = currentTimer.Add(new TimeSpan(0, 0, 1));
            //Обновление текущего состояния таймера
            RefreshTimer();
        }

        private void buttonStartTimer_Click(object sender, EventArgs e)
        {
            //Запуск таймера
            timer1.Start();
        }

        private void buttonStopTimer_Click(object sender, EventArgs e)
        {
            //Остановка таймера
            timer1.Stop();
        }

        private void buttonClearTimer_Click(object sender, EventArgs e)
        {
            //Остановка таймера
            timer1.Stop();
            //Сброс текущего состояния таймера
            currentTimer = new TimeSpan();
            //Обновление текущего состояния таймера
            RefreshTimer();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //Обновление текущего состояния таймера
            RefreshTimer();
        }

        private void buttonOpenNonModal_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.Show();
        }

        private void buttonOpenModal_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.ShowDialog();
        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
