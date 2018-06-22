//Л7:Linenum.cpp Нумерация строк
#include <vector> 
#include <string> 
#include <fstream> 
#include <iostream>
#include <iomanip>
 
using namespace std;

int main(int argc, char* argv[]) {
	system("chcp 1251>nul");
	if(argc<2){
		cout<<"Добавьте в argv[] файл для нумерации строк"<<endl;//HowMany.txt
		system("pause");	return 0;}
	ifstream fin(argv[1]); 
	if(!fin.is_open()){
		cout<<"Добавьте в папку файл для нумерации строк"<<endl;
		system("pause");
		return 0;
	}
	string line; 
	vector<string> lines;
	while(getline(fin, line))// Чтение всего файла argv[1]
		lines.push_back(line); 
	if(lines.size() == 0) return 0; 
	int num = 0; 
	// Ширина поля вывода номера строки в файле argv[1], 
	const int width = 3;//в файле не больше 1000 строк
	for(int i = 0; i < lines.size(); i++) {
		cout <<setw(width)<< ++num << ") " << lines[i] << endl;
	}
	system("pause");
}