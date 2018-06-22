//: L10 Instrument.cpp
// ������������ � ���������� ���������� ���� 
#include <iostream>
using namespace std; 
enum note { Do, Re, Ci };// � �. �.
class Instrument {
//	int i;
 	public:
	 void play(note) const {
		cout << "Instrument::play" << endl;
	}
};
// ������� ����������� ����������� (Wind) �������� ������������
// ������������� (Instrument), ��������� �������� ��� �� 
//�����������: 
class Wind : public Instrument {
    public: // ��������������� ������������ �������: 
	void play(note) const {
	cout << "Wind::play" << endl; 
	} 
};
class Stringed : public Instrument {//��������
    public: // ��������������� ������������ �������: 
	void play(note) const {
	cout << "Stringed::play" << endl; 
	} 
};
	void tune(Instrument* i) {//�������
	 // ... 
	i->play(Ci);
	 }

int main() {
	system("chcp 1251>nul");
	Instrument* A[2];
 	Wind flute;
	Stringed violin;
	cout<<"������ ������� Wind = "<<sizeof(Wind)<<endl;
	cout<<"������ ������� Instrument = "<<sizeof(Instrument)<<endl;
	A[0]=&flute;//(������)���������� ���������� ����
	A[1]=&violin;//(�������)���������� ���������� ����
	tune(A[0]); 
	tune(A[1]);
	system("pause");
	return 0;
}
