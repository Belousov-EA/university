#include "dbmsLib.h"
using namespace std;
namespace dbmsLib
{
const char* typeNames[]={
	"NoType",
	"Int32",
	"Double",
	"String",
	"DBDate"
};
const char* DBTable::TypeName(DBType type){
	return typeNames[type];
}

DBType DBTable::GetType(char* columnName){
	int N=sizeof(typeNames)/4;
	for(int i=0;i<N;i++)
		if(!strcmp(typeNames[i],columnName))//(string)typeNames[i]==columnName)			
			return (DBType)i;
	return (DBType)0;
}
DBTable::DBTable(string tabName){
	tableName=tabName;
}
DBTable::DBTable(string tabName,Header hdr,string primKey){
	tableName=tabName;
	primaryKey=primKey;
	columnHeaders=hdr;
}
}