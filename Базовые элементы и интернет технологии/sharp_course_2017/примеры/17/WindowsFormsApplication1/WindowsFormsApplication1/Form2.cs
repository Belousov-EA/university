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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Form2_FormClosed(object sender, FormClosedEventArgs e)
        {
            MessageBox.Show("Форма 2 закрылась!");
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            //Вывод диалогового окна
            DialogResult result = MessageBox.Show("Вы действительно хотите закрыть форму 2?",
                "Уважаемый пользователь", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            //Отмена закрытия окна
            if (result == DialogResult.No)
            {
                e.Cancel = true;
            }
        }
    }
}
