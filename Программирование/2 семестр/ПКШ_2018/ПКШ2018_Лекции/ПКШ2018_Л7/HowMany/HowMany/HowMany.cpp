//HowMany.cpp 
// Копирующий конструктор 
#include <fstream> 
#include <string> 
using namespace std;

ofstream fout("HowMany.txt");
class HowMany {
	string name; // Идентификатор объекта 
	static int objectCount; 
	public: HowMany(const string& id = "") : name(id) {
			++objectCount; 
			print("HowMany()"); 
		} 
		~HowMany() {
			--objectCount; 
			print("~HowMany()");
		} 
		// Копирующий конструктор: 
		HowMany(const HowMany& h) : name(h.name) {
			name += " copy";
			++objectCount;
			print("HowMany(const HowMany&)");
		} 
		void print(const string &msg = "") const {
			if(msg.size() != 0) 
				fout << msg << endl;
				fout << '\t' << name << ": " 
				<< "objectCount = " << objectCount << endl; 
		} 
};
int HowMany::objectCount = 0;//инициализация статической переменной
//---------------------------------------------------------
// Передача и возврат ПО ЗНАЧЕНИЮ: 
	HowMany f(HowMany x) {
	x.print("x argument inside f()");
	fout << "Returning from f()" << endl;
	return x;
	}

int main() { 
	HowMany h("h"); 
	fout << "Entering f()" << endl;
	HowMany h2 = f(h);
	h2.print("h2 after call to f()");
	fout << "Call f(), no return value" << endl;
	f(h);
	fout << "After call to f()" << endl;
	system("pause");
} 