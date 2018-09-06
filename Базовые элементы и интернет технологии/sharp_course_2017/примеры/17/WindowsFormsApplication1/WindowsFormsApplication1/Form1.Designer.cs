namespace WindowsFormsApplication1
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.button1 = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.label2 = new System.Windows.Forms.Label();
            this.textTimer = new System.Windows.Forms.TextBox();
            this.buttonStartTimer = new System.Windows.Forms.Button();
            this.buttonStopTimer = new System.Windows.Forms.Button();
            this.buttonClearTimer = new System.Windows.Forms.Button();
            this.buttonOpenNonModal = new System.Windows.Forms.Button();
            this.buttonOpenModal = new System.Windows.Forms.Button();
            this.buttonClose = new System.Windows.Forms.Button();
            this.buttonExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(472, 15);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Тест";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(157, 17);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(309, 20);
            this.textBox1.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(139, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Текст по нажатию кнопки";
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(93, 61);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Таймер:";
            // 
            // textTimer
            // 
            this.textTimer.Location = new System.Drawing.Point(157, 61);
            this.textTimer.Name = "textTimer";
            this.textTimer.Size = new System.Drawing.Size(100, 20);
            this.textTimer.TabIndex = 4;
            // 
            // buttonStartTimer
            // 
            this.buttonStartTimer.Location = new System.Drawing.Point(76, 87);
            this.buttonStartTimer.Name = "buttonStartTimer";
            this.buttonStartTimer.Size = new System.Drawing.Size(75, 23);
            this.buttonStartTimer.TabIndex = 5;
            this.buttonStartTimer.Text = "Старт";
            this.buttonStartTimer.UseVisualStyleBackColor = true;
            this.buttonStartTimer.Click += new System.EventHandler(this.buttonStartTimer_Click);
            // 
            // buttonStopTimer
            // 
            this.buttonStopTimer.Location = new System.Drawing.Point(157, 87);
            this.buttonStopTimer.Name = "buttonStopTimer";
            this.buttonStopTimer.Size = new System.Drawing.Size(75, 23);
            this.buttonStopTimer.TabIndex = 6;
            this.buttonStopTimer.Text = "Стоп";
            this.buttonStopTimer.UseVisualStyleBackColor = true;
            this.buttonStopTimer.Click += new System.EventHandler(this.buttonStopTimer_Click);
            // 
            // buttonClearTimer
            // 
            this.buttonClearTimer.Location = new System.Drawing.Point(238, 87);
            this.buttonClearTimer.Name = "buttonClearTimer";
            this.buttonClearTimer.Size = new System.Drawing.Size(75, 23);
            this.buttonClearTimer.TabIndex = 7;
            this.buttonClearTimer.Text = "Сброс";
            this.buttonClearTimer.UseVisualStyleBackColor = true;
            this.buttonClearTimer.Click += new System.EventHandler(this.buttonClearTimer_Click);
            // 
            // buttonOpenNonModal
            // 
            this.buttonOpenNonModal.Location = new System.Drawing.Point(15, 137);
            this.buttonOpenNonModal.Name = "buttonOpenNonModal";
            this.buttonOpenNonModal.Size = new System.Drawing.Size(248, 23);
            this.buttonOpenNonModal.TabIndex = 8;
            this.buttonOpenNonModal.Text = "Открыть немодальное окно";
            this.buttonOpenNonModal.UseVisualStyleBackColor = true;
            this.buttonOpenNonModal.Click += new System.EventHandler(this.buttonOpenNonModal_Click);
            // 
            // buttonOpenModal
            // 
            this.buttonOpenModal.Location = new System.Drawing.Point(15, 167);
            this.buttonOpenModal.Name = "buttonOpenModal";
            this.buttonOpenModal.Size = new System.Drawing.Size(248, 23);
            this.buttonOpenModal.TabIndex = 9;
            this.buttonOpenModal.Text = "Открыть модальное окно";
            this.buttonOpenModal.UseVisualStyleBackColor = true;
            this.buttonOpenModal.Click += new System.EventHandler(this.buttonOpenModal_Click);
            // 
            // buttonClose
            // 
            this.buttonClose.Location = new System.Drawing.Point(15, 197);
            this.buttonClose.Name = "buttonClose";
            this.buttonClose.Size = new System.Drawing.Size(248, 23);
            this.buttonClose.TabIndex = 10;
            this.buttonClose.Text = "Закрыть окно";
            this.buttonClose.UseVisualStyleBackColor = true;
            this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
            // 
            // buttonExit
            // 
            this.buttonExit.Location = new System.Drawing.Point(15, 227);
            this.buttonExit.Name = "buttonExit";
            this.buttonExit.Size = new System.Drawing.Size(248, 23);
            this.buttonExit.TabIndex = 11;
            this.buttonExit.Text = "Закрыть приложение";
            this.buttonExit.UseVisualStyleBackColor = true;
            this.buttonExit.Click += new System.EventHandler(this.buttonExit_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(591, 262);
            this.Controls.Add(this.buttonExit);
            this.Controls.Add(this.buttonClose);
            this.Controls.Add(this.buttonOpenModal);
            this.Controls.Add(this.buttonOpenNonModal);
            this.Controls.Add(this.buttonClearTimer);
            this.Controls.Add(this.buttonStopTimer);
            this.Controls.Add(this.buttonStartTimer);
            this.Controls.Add(this.textTimer);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textTimer;
        private System.Windows.Forms.Button buttonStartTimer;
        private System.Windows.Forms.Button buttonStopTimer;
        private System.Windows.Forms.Button buttonClearTimer;
        private System.Windows.Forms.Button buttonOpenNonModal;
        private System.Windows.Forms.Button buttonOpenModal;
        private System.Windows.Forms.Button buttonClose;
        private System.Windows.Forms.Button buttonExit;
    }
}

