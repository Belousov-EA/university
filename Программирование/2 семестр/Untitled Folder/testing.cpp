#include "dbmsLib.h"
using namespace std;

//----------menu( )---------------------------------  
int menu() 
{
	int action;
	cout<<"====== ���������� ���������� ������� ��� ������ ���� v.1 ======\n";
	cout<<"1 - ������ ������� �� �����\t 2 - ������ �������\n";
	cout<<"3 - ������ ������� � ����\t 4 - ��������� �������� ����� �������\n";
	cout<<"5 - ������������\t\t 6 - �����\n"; 
	cout<<"===========================================================\n";
	cout<<("������� ����� ��������\n");
	cin>>action;
	while(cin.fail())
	{
		cin.clear();
		cin.ignore(10,'\n');					
		cout<<("������ �������. ��������� ���� ������ ��������\n");
		cin>>action;
	}			
	return action;
}//--------------- friend dbmsLib::DBTableTxt void ReadDBTable1 ------------------ 
//void dbmsLib:: ReadDBTable1(dbmsLib::DBTableTxt& tab, string path){ 
//	tab.tableName="stud";
//
//}
//------------------------------------------------------------
void ChangeValueInTab(dbmsLib::DBTableTxt& tab){
	cout<<"ChangeValueInTab "<<tab.GetTableName()<<endl; 
	(*(int*)(tab[1]["StudentID"]))++;
}
//-------------------------------------------------------------
void Testing(string dbName,string tabName){
	string path(dbName);
	dbmsLib::DBTableTxt students;
	students.ReadDBTable(path+tabName+".txt");
	//ReadDBTable1(students,path+tabName+".txt");
	students.PrintTable(78);
	//���������� ��������� � ������� Students � ����
	//ChangeValueInTab( students);
	students.WriteDBTable(path);
	students.ReadDBTable(path);
	students.PrintTable(78);
}
int main()
{
	system("chcp 1251 > nul");
	cout<<"������� ��� ��\n"; //"LibraryTxt" "CompanyTxt"
	//��� �������� ������������ ��� ������� ��������� ������������
	string dbName("LibraryTxt");
	//cin>>dbName;
	cout<<dbName<<endl;
	cout<<"������� ��� ������� ��\n";
	//"Students" "Abonements" "Books"- ��� LibraryTxt
	//"Products";"OrderDetails";"Orders";"Customers"- ��� CompanyTxt
	string tabName("Students");	
	//cin>>tabName;
	dbmsLib::DBTableTxt tab;//�������� ������ ������� ������ DBTableTxt,
		//������������� � ������������ � ������� ���������� dbmsStatLib
	string path("..\\"+dbName+"\\");
	//tab.ReadDBTable(path+tabName+".txt");
	//	cout<<"������� ������� ���� dd.mm.yyyy\n";
	string str("25.01.2018");
	//	cin>>str;
	dbmsLib::DBDate today(str);
	//	cout<<"������� ������ ������ � ��������\n";
	int screenWidth=78;
	//	cin>>screenWidth;
	while(true)
	{ 
		switch (menu())
		{
		case 1: tab.ReadDBTable(path+tabName+".txt");//������ ������ ��. 
			//�� �������� � ����� "..\\"+dbName+". 
			//��� �� ������������ ��� �� Txt, ���� ������� �� �������� � ��������� ������,
			//������ ������� �������� � ��������� ����� � ������ = <��� �������>+".txt"
			//��������� �����:
			//������ ������ ����� �������� ��� ������� � ��� ������� � ��������� ������
			//������ ������ ����� - ��������� �������.
			//��� ����������� ������ - ������ �������.
			break;
		case 2: tab.PrintTable(screenWidth);//������ ������� �� (screenWidth-������ ������)
			break;
		case 3: tab.WriteDBTable(path+tabName+".txt");break;
		case 4: ChangeValueInTab(tab); break; 
		case 5: Testing(path,tabName); break;
		case 6: return 0;
		default: cout<<(" ���� ������� ����� �� 1 �� 6\n"); break;
		}    	
	}
	system("pause");
	return 0;
}