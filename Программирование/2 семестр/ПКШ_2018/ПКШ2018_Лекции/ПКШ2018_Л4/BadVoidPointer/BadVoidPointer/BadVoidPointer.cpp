//BadVoidPointerDeletion.cpp 
//Вызов delete для указателей на void может привести к утечке памяти 
#include <iostream> 
using namespace std;
class Object {
	void* data; // Некий блок памяти 
	const int size; 
	const char id; //идентификатор объекта
public: 
	Object(int sz, char c) : size(sz), id(c) {
			data = new char[size];
			cout << "Конструктор объекта " << id << 
					".  size = " << size << endl; 
		}
		~Object() { 
			cout << "Деструктор объекта " << id << endl;
			delete []data; // ОК. просто освобождаем память. 
			// вызов деструктора для char не нужен. 
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
