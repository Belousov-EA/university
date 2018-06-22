//L8:OverloadingConversion.срр 

/*Операторы преобразования (conversion operator) определяют 
преобразование объекта одного типа в другой. 
Они имеют следующий общий синтаксис:
operator тип() const;
В данном случае тип - это тот тип, в который надо преобразовать. 
Операции преобразования не должны изменять преобразуемый объект,
поэтому функции операторов определяются с ключевым словом const.
Например, определим оператор преобразования из типа класса в тип int:
 В данном случае в классе Counter определен оператор 
преобразования от типа Counter к типу int:
operator int() const
{
    return seconds;
}
Поэтому в программе мы можем использовать неявные преобразования
от Counter к int:
int sec = counter;

/* В классе Counter определен оператор преобразования объекта
из типа Counter в тип Clock, то есть по сути из секунд необходимо 
получить часы, минуты и секунды. 
Если этот оператор определен как явная операция 
преобразования (с использованием explicit), то при использовании данной операции 
необходимо перед преобразуемым типом ставить операцию приведения
- в скобках указывается тип, к которому надо пребразовать объект:
Clock clock = (Clock)counter;
*/
/*Также можно определить обратное образование из типа Clock в тип Counter.
Для этого можно определить конструктор в классе Counter, 
который применяет ссылку на объект Clock:
*/
#include <iostream>
using namespace std;

class Clock
{
public:
    int hours;
    int minutes;
    int seconds;
    Clock(int h, int m, int s) : hours(h), minutes(m), seconds(s)
    {
    }
    void display()
    {
        std::cout << hours << ":" << minutes << ":" << seconds << std::endl;
    }
};
class Counter
{
public:
    explicit
		Counter(int sec): seconds(sec)
    {
    }
    Counter(const Clock &clock)
    {
        seconds = clock.hours * 3600 + clock.minutes * 60 + clock.seconds;
    }
    void display()
    {
        std::cout << seconds << " seconds" << std::endl;
    }
	//explicit
			operator int() const//преобразование из Counter в int 
    {
        return seconds;
    }
    //explicit
				operator Clock() const
    {
        int h = seconds / 3600;
        int m = (seconds - h * 3600) / 60;
        int s = seconds - h*3600 - m*60;
        return Clock(h, m, s);
    }
private:
    int seconds;
};
int main()
{
    Counter counter(1230);
	int n= 10+counter;//ошибка, если Counter::operator int() explicit 
//	counter=12;//ошибка, если конструктор explicit
    counter.display();      // 1230 seconds
    Clock clock = //(Clock)
						counter;
    clock.display();        // 0:20:30
    Counter counter2(clock);
    counter2.display();     // 1230 seconds
	system("pause");
    return 0;
}