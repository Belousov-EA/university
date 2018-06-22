//���� TStack2Test.���
#include <iostream> 
#include <fstream> 
#include <string>
#include "TStack2.h" 

using namespace std;
int main() { 
	system("chcp 1251>nul");
	ifstream fin("TStack2Test.cpp"); 
	if(!fin.is_open()){
		cout<<"������ �������� ����� TStack2Test.cpp"<<endl;
		system("pause");
		return 0;
	} 
	TStack2<string> textlines;
	// ������ ����� � �������� ����� � Stack2:
	string line;
	while(getline(fin,line)) 
		textlines.push(new string(line)); 
	int i =0; 
	// ������������� ��������� ��� ������ ����� �� ������: 
	TStack2<string>::iterator it1 = textlines.begin(); 
	TStack2<string>::iterator* it2 = NULL; 
	while(it1 != textlines.end()) {
		cout <<**it1<< endl;
		it1++; 
		if(++i == 10) // �������� ��������������� ��������� ��� 10-� ������ 
			it2 = new TStack2<string>::iterator(it1); //����� ������������ �����������
		} 
	cout << *(it2->current()) << endl;	
	delete it2;	
	system("pause");
	return 0;
};