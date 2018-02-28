#include "dbmsLib.h"
using namespace std;

//----------menu( )---------------------------------  
int menu() 
{
	int action;
	cout<<"====== Разработка библиотеки классов для макета СУБД v.1 ======\n";
	cout<<"1 - чтение таблицы из файла\t 2 - печать таблицы\n";
	cout<<"3 - запись таблицы в файл\t 4 - изменение значений полей таблицы\n";
	cout<<"5 - тестирование\t\t 6 - выход\n"; 
	cout<<"===========================================================\n";
	cout<<("Введите номер операции\n");
	cin>>action;
	while(cin.fail())
	{
		cin.clear();
		cin.ignore(10,'\n');					
		cout<<("Ошибка формата. Повторите ввод номера операции\n");
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
	//записываем изменения в таблице Students в файл
	//ChangeValueInTab( students);
	students.WriteDBTable(path);
	students.ReadDBTable(path);
	students.PrintTable(78);
}
int main()
{
	system("chcp 1251 > nul");
	cout<<"Введите имя БД\n"; //"LibraryTxt" "CompanyTxt"
	//для удобства тестирования при отладке выполняем присваивание
	string dbName("LibraryTxt");
	//cin>>dbName;
	cout<<dbName<<endl;
	cout<<"Введите имя таблицы БД\n";
	//"Students" "Abonements" "Books"- для LibraryTxt
	//"Products";"OrderDetails";"Orders";"Customers"- для CompanyTxt
	string tabName("Students");	
	//cin>>tabName;
	dbmsLib::DBTableTxt tab;//создание пустой таблицы класса DBTableTxt,
		//определенного в подключенной к проекту библиотеке dbmsStatLib
	string path("..\\"+dbName+"\\");
	//tab.ReadDBTable(path+tabName+".txt");
	//	cout<<"Введите текущую дату dd.mm.yyyy\n";
	string str("25.01.2018");
	//	cin>>str;
	dbmsLib::DBDate today(str);
	//	cout<<"Введите ширину экрана в символах\n";
	int screenWidth=78;
	//	cin>>screenWidth;
	while(true)
	{ 
		switch (menu())
		{
		case 1: tab.ReadDBTable(path+tabName+".txt");//Чтение таблиц БД. 
			//БД хранится в папке "..\\"+dbName+". 
			//Имя БД оканчивается или на Txt, если таблицы БД хранятся в текстовых файлах,
			//Каждая таблица хранится в отдельном файле с именем = <имя таблицы>+".txt"
			//Структура файла:
			//Первая строка файла содержит имя таблицы и имя столбца с первичным ключем
			//Вторая строка файла - заголовок таблицы.
			//Все последующие строки - записи таблицы.
			break;
		case 2: tab.PrintTable(screenWidth);//Печать таблицы БД (screenWidth-ширина экрана)
			break;
		case 3: tab.WriteDBTable(path+tabName+".txt");break;
		case 4: ChangeValueInTab(tab); break; 
		case 5: Testing(path,tabName); break;
		case 6: return 0;
		default: cout<<(" Надо вводить число от 1 до 6\n"); break;
		}    	
	}
	system("pause");
	return 0;
}