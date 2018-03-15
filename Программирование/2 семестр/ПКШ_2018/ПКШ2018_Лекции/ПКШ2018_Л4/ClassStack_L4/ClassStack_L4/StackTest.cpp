// файл StackTest.срр 
// Конструкторы и деструкторы
#include "Stack.h"
#include <fstream> 
#include <iostream> 
#include <string> 
using namespace std;
int main() {
	system("chcp 1251>nul");
	ifstream in("Stack.h"); 
	{
	Stack textlines;
	 string line; 
	// Чтение файла и сохранение строк в стеке: 
	while(getline(in, line)) 
		textlines.push(new string(line)); 
	// Извлечение строк из стека и вывод: 
	
	string* s;
	while((s = (string*)textlines.pop()) != 0) {
		 cout << *s << endl;
		 delete s;
		}//вызов деструктора для Stack textlines
	}
	system("pause");
	return 0;
} 
