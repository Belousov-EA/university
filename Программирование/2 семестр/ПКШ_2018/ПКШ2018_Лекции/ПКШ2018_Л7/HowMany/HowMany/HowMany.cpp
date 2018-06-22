//HowMany.cpp 
// ���������� ����������� 
#include <fstream> 
#include <string> 
using namespace std;

ofstream fout("HowMany.txt");
class HowMany {
	string name; // ������������� ������� 
	static int objectCount; 
	public: HowMany(const string& id = "") : name(id) {
			++objectCount; 
			print("HowMany()"); 
		} 
		~HowMany() {
			--objectCount; 
			print("~HowMany()");
		} 
		// ���������� �����������: 
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
int HowMany::objectCount = 0;//������������� ����������� ����������
//---------------------------------------------------------
// �������� � ������� �� ��������: 
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