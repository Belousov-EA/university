using namespace std;
namespace dbmsLib
{
//---------------------------------------------------
//---------------------------------------------------
//======typeNames[]--массив имен типов полей таблиц БД
const char* typeNames[]={
 "NoType",
 "Int32",
 "Double",
 "String",
 "DBDate"
};
//=====================Глобальные функции====================
//extern const char** typeNames;
//DBType GetType(string columnName)
//	{		
//		int N=4;//sizeof(typeNames)/4;
//		for(int i=0;i<N;i++)
//			if(strcmp(typeNames[i],columnName.c_str()))//(string)typeNames[i]==columnName)			
//				return (DBType)i;
//		return (DBType)0;
//	}
//-----------------------------------------------------
void* GetValue(string value, string columnName,Header hdr)
	//возвращает значение переменной value, преобразованное из типа   
	//string в тип typeName, имя которого указано в заголовке  
	//столбца таблицы в CVS-файле.
{
	switch (hdr[columnName].colType)
	{
//	case Int32:		return new int(atoi(value.c_str()); break;
	case Int32:		return new int(stoi(value)); break;
	case Double:	return new double(stod(value)); break;
	case String:	return new string(value); break;
	case Date:		return new DBDate(value); break;
	default: cout<<"Недопустимый тип данных в столбце\n"<<
				 columnName<<endl;
	}
	return 0;
} 
//------------------------------------------------------------------------
string ignoreBlanc(const string str){		
	string bufStr=str;
	int begStr=bufStr.find_first_not_of(' ');
	return bufStr.substr(begStr);
}
//===========================================================
//извлечение имени таблицы из полного имени файла (путь из текущей папки)	
string GetTabNameFromPath(string path){
	char tName[100];
	int pos1=path.find_last_of('\\');
	int pos2=path.find_last_of('.');
	strcpy_s(tName,100,path.c_str());
	tName[pos2]='\0';
	strcpy_s(tName,80,tName+pos1+1);
	return tName;
}
//===================================================
bool comparator(DBType type,void *obj1,Condition condition,void *obj2){
	switch (type){
	case Int32: switch (condition){
	case	Equal:		return *(int*)obj1 == *(int*)obj2;
	case NotEqual:		return *(int*)obj1 != *(int*)obj2;
	case	 Less:		return *(int*)obj1 < *(int*)obj2;
	case  Greater:		return *(int*)obj1 > *(int*)obj2;
	case LessOrEqual:	return *(int*)obj1 <= *(int*)obj2;
	case GreaterOrEqual: return *(int*)obj1 >= *(int*)obj2;
	default: cout<<"Недопустимая операция сравнения\n"<<endl;
		return false;
				}
	case Double: switch (condition){
	case	Equal:		return *(double*)obj1 == *(double*)obj2;
	case NotEqual:		return *(double*)obj1 != *(double*)obj2;
	case	 Less:		return *(double*)obj1 < *(double*)obj2;
	case  Greater:		return *(double*)obj1 > *(double*)obj2;
	case LessOrEqual:	return *(double*)obj1 <= *(double*)obj2;
	case GreaterOrEqual: return *(double*)obj1 >= *(double*)obj2;
	default: cout<<"Недопустимая операция сравнения\n"<<endl;
		return false;
		}
	case String: //пропуск ведущих пробелов в string
		switch (condition){
		case	Equal:		return ignoreBlanc(*(string*)obj1) == ignoreBlanc(*(string*)obj2);
		case NotEqual:		return ignoreBlanc(*(string*)obj1) != ignoreBlanc(*(string*)obj2);
		case	 Less:		return ignoreBlanc(*(string*)obj1) < ignoreBlanc(*(string*)obj2);
		case  Greater:		return ignoreBlanc(*(string*)obj1) > ignoreBlanc(*(string*)obj2);
		case LessOrEqual:	return ignoreBlanc(*(string*)obj1) <= ignoreBlanc(*(string*)obj2);
		case GreaterOrEqual: return ignoreBlanc(*(string*)obj1)>= ignoreBlanc(*(string*)obj2);
		default: cout<<"Недопустимая операция сравнения\n"<<endl;
			return false;
		}
	case Date: switch (condition){
	case	Equal:		return *(DBDate*)obj1 == *(DBDate*)obj2;
	case NotEqual:		return *(DBDate*)obj1 != *(DBDate*)obj2;
	case	 Less:		return *(DBDate*)obj1 < *(DBDate*)obj2;
	case  Greater:		return *(DBDate*)obj1 > *(DBDate*)obj2;
	case LessOrEqual:	return *(DBDate*)obj1 <= *(DBDate*)obj2;
	case GreaterOrEqual: return *(DBDate*)obj1 >= *(DBDate*)obj2;
	default: cout<<"Недопустимая операция сравнения\n"<<endl;
		return false;
		}	
	default: cout<<"Недопустимый тип данных\n"<<endl;
		return false;
	}
}	

//----------------------------------------------
DBTableTxt::DBTableTxt(string tabName){
	tableName=tabName;
}
const char* DBTableTxt::TypeName(DBType type){
	return typeNames[type];
}

DBType DBTableTxt::GetType(char* tName){//tName - имя типа
	int N=sizeof(typeNames)/4;
	for(int i=0;i<N;i++)
		if(!strcmp(typeNames[i],tName))//(string)typeNames[i]==tName)			
			return (DBType)i;
	return (DBType)0;
}
//----------------------------------------------------------------------
DBTableTxt::DBTableTxt(string tabName,Header hdr,string primKey){
	tableName=tabName;
	columnHeaders=hdr;
	primKey=primaryKey;
}
Row DBTableTxt::CreateRow()
{
	Row row;
	Header::iterator iter;
	Header hd=GetHeader();
	void* id;
	string primKey=GetPrimaryKey();
	if(primKey!="NoPrimaryKey"){
		id=GetRow(GetSize()-1)[primKey];
		cout<<"Последнее значение PrimaryKey "<< primKey + " = "<<
			valueToString(GetRow(GetSize()-1),primKey)<<endl;
	}
	cout<<"Введите строку таблицы "<<GetTableName()<<endl;
	char line[80];
	for(iter=hd.begin(); iter!=hd.end(); iter++){
		cout<<iter->first<<"  "<<TypeName(iter->second.colType)<<' '<<
			iter->second.length<<endl;//печать приглашений для ввода столбцов строки 
		cin.sync();
		cin.getline(line,80);
		string str(line);
		row[iter->first]=GetValue(str, iter->first,hd);
	}

	return row;
}
//=====================класс DBTableTxt=========================
vector<int> DBTableTxt::IndexOfRecord(void* keyValue,string keyColumnName){
	//keyValue можно посмотреть в окне "Контрольные значения" как *(string*)keyValue.
	// Следует различать порядковый номер записи (её индекс)
	//и значение первичного ключа (даже если он целочисленный).
	//В дочерних таблицах выполняется поиск по значению вторичнного ключа и
	//найденных записей может быть несколько. Поэтому возвращать будем вектор,
	//а в функцию добавим ещё один параметр - имя ключевого столбца.
	int ind=0;//порядковый номер (индекс) строки в таблице (строка = data[ind])
	vector<int> indexes;//вектор индексов строк cо значением ключа keyName, равным keyPtr 
	//	Header hdr=GetHeader();
	//	bool b=false;
	for (ind = 0; ind <data.size(); ind++)
	{ 
		if(comparator(columnHeaders[keyColumnName].colType,
			data[ind][keyColumnName],Equal, keyValue))
		{
			indexes.push_back(ind);
		}
	}
	//проверку вынести в вызывающую функцию (пока  нет обработки исключений)
	//if(indexes.size()==0){
	//	cout<<"Несуществующее значение ключа "<<keyColumnName<< "в таблице "<<tabName<<
	//	",\n программа "<<"vector<int> IndexOfRecord(string keyName,void* keyValue)"<<endl;
	//	system("pause");		
	//}
	return indexes;
}
//------------------------------------------------------------
Row& DBTableTxt::GetRow(int index){
	return data[index];
}
//-----------------------------------------------
string DBTableTxt::valueToString(Row& row,string columnName)
	//возвращает значение переменной value, преобразованное из типа   
	//typeName, имя которого указано в заголовке columnName столбца  
	//таблицы, в тип string.
	//!!! Вставить проверку наличия columnName в	DBTableTxt
{
	char buf[80]={0};
	if (this->columnHeaders.find(columnName)!= this->columnHeaders.end())  
	{ 		
		void* value=row[columnName];//потенциально опасная операция
		ostrstream os(buf,80);
		switch(columnHeaders[columnName].colType){
		case Int32: os<<setw(8)<<*(int*) value<<'\0'; break;
		case Double: os<<setw(12)<<*(double*) value<<'\0'; break;
		case String:os<<setw(columnHeaders[columnName].length)<<
						ignoreBlanc(*(string*)value)<<'\0'; break;
		case Date: os<<setw(12)<<*(DBDate*) value<<'\0'; break;
		default: cout<<setw(8)<<"NoType"<<'\0'; 
			system("pause");break;
		}	
	}else
		cout << "column not found " << endl;
	return buf;
}
//============================================================================
//-------Чтение данных из файла в таблицу -------
void DBTableTxt::ReadDBTable(string fileName)//!!! fileName - путь из текущей папки
{		
	//Извлечение имени таблицы из fileName (путь к файлу из текущей папки)
	string tabName=GetTabNameFromPath(fileName);
	//	SetTableName(tabName);
	ifstream fin;//открытие файлового потока на ввод
	fin.open(fileName,ios::binary|ios::in);
	if (!fin.is_open())	
	{ 
		cout<<"Ошибка открытия файла "<<fileName<<endl; 
		system("pause");
		return;
	}
	char line[200];
	vector<ColumnDesc> strArray;//буфер для чтения строки заголовка таблицы
	char *token=0, *next_token = line;
	char*delims="|\r\n";
	//Прочитать имя таблицы и имя столбца с primaryKey из первой строки файла
	fin.getline(line, 200);
	token = strtok_s( next_token, delims, &next_token);
	tableName=token;
	token = strtok_s( next_token, delims, &next_token);
	primaryKey=token;
	//Прочитать заголовок таблицы из второй строки файла
	//и записать его в table.columnHeaders
	columnHeaders.clear();
	fin.getline(line, 200); //чтение заголовка
	next_token=line;
	//цикл по словам (лексемам) в строке
	ColumnDesc colHdr;
	while( (token = strtok_s( next_token, delims, &next_token)) != NULL ) 
	{
		strcpy_s(colHdr.colName,token);
		token = strtok_s( next_token, delims, &next_token);
		colHdr.colType=GetType(token);//token - имя типа
		token = strtok_s( next_token, delims, &next_token);
		colHdr.length=atoi(token);
		strArray.push_back(colHdr);			
	}
	Header hdr;
	for (unsigned int  j = 0; j < strArray.size() ;  j ++)
	{
		hdr[strArray[j].colName]=strArray[j];

	}	
	SetHeader(hdr);
	//читаем строки в line (до EOF) и записываем их в table.data
	data.clear();
	while (fin.getline(line, 200))
	{		
		Row row=*(new Row());//буфер для формирования строки таблицы
		int j = 0;
		token = strtok_s( line, delims, &next_token);
		//цикл по столбцам (словам) в строке
		while(token) 
		{
			string value=token;
			//добавление поля в строку с преобразованием типа
			//strArray[j] - имя столбца в заголовке таблицы
			row[strArray[j].colName]=GetValue(value,strArray[j].colName,columnHeaders);												
			/*	cout.write((char*) row[strArray[j].colName],
			columnHeaders[strArray[j].colName].length);*/
			j=j++;//индекс следуещего столбца в векторе strArray
			token = strtok_s( next_token, delims, &next_token);
		}
		data.push_back(row);//добавить строку данных в таблицу
	}
	fin.close();
}
//---------Печать таблицы --------------------------------------
//int screenWidth - ширина экрана.
//Если ширина таблицы больше ширины экрана, то таблица печатается в 
//несколько полос, размещаемых друг под другом. В каждой полосе печатается
//последовательность столбцов, по ширине не превышающая ширину экрана.
//В полосе выводятся все строки размещенных в ней столбцов.
//Столбцы, не поместившиеся на экране, печатаются в последующих полосах.
//Число столбцов, их наименование, тип и размер данных в столбцах
//определяются из заголовка таблицы.
//Количество полос, число и ширина полей в полосе описываются макетом таблицы.
//----------Создать макет распечатки таблицы---------------------
void DBTableTxt::CreateTableMaket(Strip *&strips,int &nStrips,int screenWidth)
{
	Header::iterator headerIter,contHeaderIter;		
	int nColumn = (int)columnHeaders.size();
	//Заполнение массива ширины полей для печати таблицы 
	int* fieldW=new int[nColumn];
	headerIter=columnHeaders.begin();
	for(int k=0;k<nColumn; k++){
		//что шире: заголовок или данные?
		fieldW[k]=headerIter->second.length > headerIter->first.size() ?
			headerIter->second.length+2 : headerIter->first.size()+2;
		headerIter++;
	}
	int currCol=0;//порядковый номер столбца в таблице
	nStrips=1;//число полос в распечатке таблицы
	int sumWidth=0;//суммарная ширина столбцов в полосе
	int n=0;//число столбцов в полосе
	int buff[40]={0};//объявление и обнуление буфера для временного 
	//хранения числа столбцов в полосе (n<40)
	for(currCol=0; currCol<nColumn; currCol++){
		if(fieldW[currCol]>=screenWidth-1){
			cout<<"Ширина столбца "<<currCol<<" больше ширины экрана\n";
			cout<<"Таблицу нельзя распечатать"<<endl;
			nStrips=0;
			return;
		}
		sumWidth+=fieldW[currCol];
		if((sumWidth<screenWidth-1)&&(currCol<nColumn-1)){
			n++;
			continue;
		}
		if((sumWidth>=screenWidth-1)){//выход за границу экрана 
			currCol--;				
			buff[nStrips-1]=n;
			nStrips++;
			n=0;
			sumWidth=0;
			continue;
		}
		if(currCol==nColumn-1){//последняя полоса
			n++;
			buff[nStrips-1]=n;
		}			
	}
	//выделение памяти и заполнение макета таблицы strips из буфера buff.
	//strips - "ступенчатый" массив размеров столбцов strips[i].fieldWidth 
	//в полосах таблицы, т.е. числа столбцов в полосе могут  отличатся.
	//Для его создания используется структура Strip (сущность более высокого,
	//по сравнению со строкой, уровня, которая скрывает различия в числе столбцов
	//в строках разных полос в макете таблицы. В результате таблица печатается в виде полос 
	//одинаковой ширины (за исключением последней полосы). В C# для этого есть 
	//специальный тип данных - "ступенчатый массив"(массив из массивов различной длины).
	//Это может рассматриваться как пример "обобщенного программирования" для печати
	//таблиц произвольного размера.
	strips=new Strip[nStrips];   
	int col = 0;
	for(int i=0;i<nStrips;i++){
		strips[i].nField=buff[i];
		strips[i].fieldWidth=new int[strips[i].nField];
		for(int j=0;j<strips[i].nField;j++)
			strips[i].fieldWidth[j]=fieldW[col++];
	}				
}
//========Вывод таблицы на экран void PrintTable(int screenWidth)=========
void DBTableTxt::PrintTable(int screenWidth)
{		
	Strip * strips;//выходной параметр функции CreateTableMaket
	int nStrips;//выходной параметр функции CreateTableMaket
	CreateTableMaket(strips,nStrips,screenWidth);
	int nColumn = (int)columnHeaders.size();
	Header::iterator headerIter,contHeaderIter;
	Row::iterator rowIter, contRowIter;
	cout<<"\nТаблица "<<tableName<<endl;
	cout<<setfill('=')<<setw(screenWidth-1)<<'='<<setfill(' ')<<endl;
	contHeaderIter=columnHeaders.begin();
	for ( int r = 0; r < nStrips; r++)
	{//печать заголовка
		//вывод наименований столбцов в заголовке полосы
		headerIter=contHeaderIter;
		for (int j = 0; j < strips[r].nField; j++)
			cout<<setw(strips[r].fieldWidth[j])<< headerIter++->first;
		cout<<endl;
		//вывод типа данных в столбцах в заголовке полосы
		headerIter=contHeaderIter;
		for (int j = 0; j < strips[r].nField; j++)
			cout<<setw(strips[r].fieldWidth[j])<< TypeName(headerIter++->second.colType);
		cout<<endl<<setfill('-')<<setw(screenWidth-1)<<'-'<<setfill(' ')<<endl;
		//печать строк таблицы
		int nRows = (int)data.size();
		for (int i = 0; i < nRows; i++)
		{
			//cout.write((*(string*)data[i]["Group"]).c_str(),8); cout<<endl;

			if(r==0){//установка итераторов на начало строки в нулевой полосе
				rowIter=data[i].begin();
				contRowIter=rowIter;
			}
			rowIter=contRowIter;//продолжение строк таблицы в новой полосе
			for (int j=0; j<strips[r].nField; j++)
			{
				//				if(dbName=="LibraryBin"||dbName=="CompanyBin")
				//			 		cout<<(*(string*)(data[i][rowIter->first])).c_str();//бинарный файл
				////				cout<<(char*)row[pr.first]<<endl;
				//				else
				//				//текстовый файл
				cout<<setw(strips[r].fieldWidth[j])<< valueToString(data[i],rowIter->first);
				rowIter++;
			}
			cout<<endl;
		}
		cout<<setfill('=')<<setw(screenWidth-1)<<'='<<setfill(' ')<<endl;
		if(r<nStrips-1){//установка итераторов продолжения печати таблицы в новой полосе
			contHeaderIter=headerIter;
			contRowIter=rowIter;
			cout<<"\nПродолжение таблицы "<< tableName<<endl;
			cout<<setfill('=')<<setw(screenWidth-1)<<'='<<setfill(' ')<<endl;					
		}		
	}
	//Освобождение памяти
	for(int i=0;i<nStrips;i++)
		for(int j=0;i<strips[i].nField;i++)//можно было бы использовать для удаления Strip
			delete []strips[i].fieldWidth;//виртуальный деструктор
	delete []strips;//вызывающая функция Print владеет объектом strips. Память
	//для strips выделяется в функции CreateTableMaket(strips,nStrips,screenWidth)
}

//================================================================================
//------Запись данных таблицы в текстовый файл с разделителями ('|').------
void DBTableTxt::WriteDBTable(string fileName)
{ 
	//извлечение имени таблицы из fileName (путь к файлу из текущей папки)
	string tabName=GetTabNameFromPath(fileName);
	if(tableName!=tableName){
		cout<<"Имя таблицы в fileName "<<tableName<<
			" не соответствует имени таблицы "<<tabName<< ",указанному в DBTableBin\n";
		system("pause");
		return;
	}
	ofstream fout;//открытие файлового потока на вывод
	fout.open(fileName);//,ios::binary|ios::out);
	if (!fout.is_open()){ 
		cout<<"Ошибка открытия файла "<<fileName<<endl; 
		system("pause");
		return;
	}
	Header::iterator iter,iterWhile;
	Row ::iterator dataIter,dataIterWhile;
	//Запись имени таблицы и имени столбца primaryKey (первая строка файла).
	fout<<tableName<<'|'<<primaryKey<<endl;
	//Запись заголовка таблицы (вторая строка файла).
	//В соответствии с форматом файла, после последнего члена 
	//строки вместо '|' нужно вставить перевод строки.
	iter=columnHeaders.begin();
	iterWhile=iter;//чтобы не печатать в цикле последнюю строку; т.к. нет
	//операций iter+1 и iter<, используем ++iterWhile (префиксный инкремент)
	while(++iterWhile!=columnHeaders.end())
	{
		fout<< iter->second.colName<<"|"<< TypeName(iter->second.colType)<<
			"|"<<iter->second.length<<"|";
		iter++;
	}
	fout<<iter->first<<"|"<< TypeName(iter->second.colType)<<"|"<<iter->second.length <<endl;
	//Запись строк таблицы.
	int nRows=(int)data.size();
	for (int i = 0; i < nRows; i++)
	{
		dataIter = data[i].begin();
		dataIterWhile=dataIter;
		while(++dataIterWhile!=data[i].end())
		{	 
			fout<<valueToString(data[i],dataIter->first)<<"|";
			dataIter++;
		}
		fout<<valueToString(data[i],dataIter->first)<<endl;
	} 
	fout.close();
}
//----------------------------------
void DBTableTxt::AddRow(Row row,int index){
	if(index==GetSize())//если строка добавляется, а не замещается
		data.push_back(row);
	else
		data[index]=row;

}
//---------------------------------------------------
string DBTableTxt::GetTableName(){
	return tableName;
}
void DBTableTxt::SetTableName(string tName){
	tableName=tName;
}
void DBTableTxt::SetPrimaryKey(string key){
	primaryKey=key;
}
//--------------------------------------------------------
Header DBTableTxt::GetHeader(){
	return columnHeaders;
}
//--------------------------------------------------------
void DBTableTxt::SetHeader(Header& hdr){
	columnHeaders=hdr;
}
//--------------------------------------------------------
void DBTableTxt::SetFileName(string path){
	fileName=path;
}
//--------------------------------------------------------
string DBTableTxt::GetFileName( ){
	return fileName;
}
//----------------------------------------------------------
int DBTableTxt::GetSize() {	
	return (int)data.size(); 
}
//-----------------------------------------------------------
Row DBTableTxt::operator[](int ind) {
	return data[ind]; 
}	

}