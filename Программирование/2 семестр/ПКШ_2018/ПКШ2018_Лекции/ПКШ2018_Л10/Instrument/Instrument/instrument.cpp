//: L10 Instrument.cpp
// Наследование и повышающее приведение типа 
#include <iostream>
using namespace std; 
enum note { Do, Re, Ci };// И т. д.
class Instrument {
//	int i;
 	public:
	 void play(note) const {
		cout << "Instrument::play" << endl;
	}
};
// Духовые музыкальные инструменты (Wind) являются музыкальными
// инструментами (Instrument), поскольку обладают тем же 
//интерфейсом: 
class Wind : public Instrument {
    public: // Переопределение интерфейсной функции: 
	void play(note) const {
	cout << "Wind::play" << endl; 
	} 
};
class Stringed : public Instrument {//струнные
    public: // Переопределение интерфейсной функции: 
	void play(note) const {
	cout << "Stringed::play" << endl; 
	} 
};
	void tune(Instrument* i) {//мелодия
	 // ... 
	i->play(Ci);
	 }

int main() {
	system("chcp 1251>nul");
	Instrument* A[2];
 	Wind flute;
	Stringed violin;
	cout<<"Размер объекта Wind = "<<sizeof(Wind)<<endl;
	cout<<"Размер объекта Instrument = "<<sizeof(Instrument)<<endl;
	A[0]=&flute;//(флейта)Повышающее приведение типа
	A[1]=&violin;//(скрипка)Повышающее приведение типа
	tune(A[0]); 
	tune(A[1]);
	system("pause");
	return 0;
}
