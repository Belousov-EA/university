//�7:Linenum.cpp ��������� �����
#include <vector> 
#include <string> 
#include <fstream> 
#include <iostream>
#include <iomanip>
 
using namespace std;

int main(int argc, char* argv[]) {
	system("chcp 1251>nul");
	if(argc<2){
		cout<<"�������� � argv[] ���� ��� ��������� �����"<<endl;//HowMany.txt
		system("pause");	return 0;}
	ifstream fin(argv[1]); 
	if(!fin.is_open()){
		cout<<"�������� � ����� ���� ��� ��������� �����"<<endl;
		system("pause");
		return 0;
	}
	string line; 
	vector<string> lines;
	while(getline(fin, line))// ������ ����� ����� argv[1]
		lines.push_back(line); 
	if(lines.size() == 0) return 0; 
	int num = 0; 
	// ������ ���� ������ ������ ������ � ����� argv[1], 
	const int width = 3;//� ����� �� ������ 1000 �����
	for(int i = 0; i < lines.size(); i++) {
		cout <<setw(width)<< ++num << ") " << lines[i] << endl;
	}
	system("pause");
}