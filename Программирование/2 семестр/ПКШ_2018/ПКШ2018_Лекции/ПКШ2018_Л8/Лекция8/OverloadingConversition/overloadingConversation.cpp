//L8:OverloadingConversion.��� 

/*��������� �������������� (conversion operator) ���������� 
�������������� ������� ������ ���� � ������. 
��� ����� ��������� ����� ���������:
operator ���() const;
� ������ ������ ��� - ��� ��� ���, � ������� ���� �������������. 
�������� �������������� �� ������ �������� ������������� ������,
������� ������� ���������� ������������ � �������� ������ const.
��������, ��������� �������� �������������� �� ���� ������ � ��� int:
 � ������ ������ � ������ Counter ��������� �������� 
�������������� �� ���� Counter � ���� int:
operator int() const
{
    return seconds;
}
������� � ��������� �� ����� ������������ ������� ��������������
�� Counter � int:
int sec = counter;

/* � ������ Counter ��������� �������� �������������� �������
�� ���� Counter � ��� Clock, �� ���� �� ���� �� ������ ���������� 
�������� ����, ������ � �������. 
���� ���� �������� ��������� ��� ����� �������� 
�������������� (� �������������� explicit), �� ��� ������������� ������ �������� 
���������� ����� ������������� ����� ������� �������� ����������
- � ������� ����������� ���, � �������� ���� ������������ ������:
Clock clock = (Clock)counter;
*/
/*����� ����� ���������� �������� ����������� �� ���� Clock � ��� Counter.
��� ����� ����� ���������� ����������� � ������ Counter, 
������� ��������� ������ �� ������ Clock:
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
			operator int() const//�������������� �� Counter � int 
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
	int n= 10+counter;//������, ���� Counter::operator int() explicit 
//	counter=12;//������, ���� ����������� explicit
    counter.display();      // 1230 seconds
    Clock clock = //(Clock)
						counter;
    clock.display();        // 0:20:30
    Counter counter2(clock);
    counter2.display();     // 1230 seconds
	system("pause");
    return 0;
}