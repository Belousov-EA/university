//файл TStack2Test.срр
#include <iostream> 
#include <fstream> 
#include <string>
#include "TStack2.h" 

using namespace std;
int main() { 
	system("chcp 1251>nul");
	ifstream fin("TStack2Test.cpp"); 
	if(!fin.is_open()){
		cout<<"Ошибка открытия файла TStack2Test.cpp"<<endl;
		system("pause");
		return 0;
	} 
	TStack2<string> textlines;
	// Чтение файла и загрузка строк в Stack2:
	string line;
	while(getline(fin,line)) 
		textlines.push(new string(line)); 
	int i =0; 
	// Использование итератора для вывода строк из списка: 
	TStack2<string>::iterator it1 = textlines.begin(); 
	TStack2<string>::iterator* it2 = NULL; 
	while(it1 != textlines.end()) {
		cout <<**it1<< endl;
		it1++; 
		if(++i == 10) // Создание дополнительного итератора для 10-й строки 
			it2 = new TStack2<string>::iterator(it1); //вызов конструктора копирования
		} 
	cout << *(it2->current()) << endl;	
	delete it2;	
	system("pause");
	return 0;
};