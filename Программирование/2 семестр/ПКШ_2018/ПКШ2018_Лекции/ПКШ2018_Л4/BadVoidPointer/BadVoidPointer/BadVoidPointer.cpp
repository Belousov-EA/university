//BadVoidPointerDeletion.cpp 
//����� delete ��� ���������� �� void ����� �������� � ������ ������ 
#include <iostream> 
using namespace std;
class Object {
	void* data; // ����� ���� ������ 
	const int size; 
	const char id; //������������� �������
public: 
	Object(int sz, char c) : size(sz), id(c) {
			data = new char[size];
			cout << "����������� ������� " << id << 
					".  size = " << size << endl; 
		}
		~Object() { 
			cout << "���������� ������� " << id << endl;
			delete []data; // ��. ������ ����������� ������. 
			// ����� ����������� ��� char �� �����. 
		} 
};
int main() { 
	system("chcp 1251 >nul");
	Object* a = new Object(40, 'a');
	delete a;
	void* b = new Object(40, 'b' );
	delete b;
	system("pause");
	return 0;
 } 
