// ���� StackTest.��� 
// ������������ � �����������
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
	// ������ ����� � ���������� ����� � �����: 
	while(getline(in, line)) 
		textlines.push(new string(line)); 
	// ���������� ����� �� ����� � �����: 
	
	string* s;
	while((s = (string*)textlines.pop()) != 0) {
		 cout << *s << endl;
		 delete s;
		}//����� ����������� ��� Stack textlines
	}
	system("pause");
	return 0;
} 
