//L10:Instruments2.срр 
// Позднее связывание с ключевым словом virtual 
#include <iostream> 
using namespace std; 

enum note { Do, Re, Ci };// И т. д.
class Instrument {
//	int i;
 	public:
	 virtual void play(note) const {
		cout << "Instrument::play" << endl;
	}
};
class Wind : public Instrument {
    public: // Переопределение интерфейсной функции: 
	void play(note) const {
	cout << "Wind::play" << endl; 
	} 
};
class Stringed : public Instrument {
    public: // Переопределение интерфейсной функции: 
	void play(note) const {
	cout << "Stringed::play" << endl; 
	} 
};
	void tune(Instrument* i) {
	 // ... 
	i->play(Ci);
	 }

int main() {
	system("chcp 1251>nul");
	Instrument* A[2];
	Wind flute;
	Stringed violin;
	cout<<"Размер объекта Wind = "<<sizeof(Wind)<<endl;
	A[0]=&flute;
	cout<<"Размер объекта Instrument = "<<sizeof(Instrument)<<endl;
	A[1]=&violin;
 	tune(A[0]); // Повышающее приведение типа
	tune(A[1]); // Повышающее приведение типа
	system("pause");
}
