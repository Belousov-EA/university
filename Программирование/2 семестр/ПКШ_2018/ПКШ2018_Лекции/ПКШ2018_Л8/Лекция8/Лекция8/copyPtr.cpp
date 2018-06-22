//L8: copyPtr.срр 
// Решение проблемы с раздвоением указателей посредством дублирования данных,
//на которые они ссылаются, при присваивании или конструировании копий. 
#include <string> 
#include <iostream> 
using namespace std;
//======================class Dog=============================
class Dog {
	 string nm; //имя собаки (значение)
public: 
// Перегружать копирующий конструктор и оператор = не нужно.
	//Перегрузка "обычных" конструкторов: 
		//Создание Dog по значению имени
	Dog(const string& name) : nm(name) {
		cout << "Creating Dog: " << *this << endl; 
	}	 
		// Создание Dog по указателю на Dog: 
	Dog(const Dog* dp, const string &msg) : nm(dp->nm + msg) {
	 	cout << "Copied dog " << *this << " from "	<< *dp << endl;
	}
		//Перегрузка деструктора
	~Dog() { 
		cout << "Deleting Dog: " << *this << endl;
	 }
	void rename(const string& newName) {
		nm = newName;
		cout << "Dog renamed to: " << *this << endl;
	 } 
	//Перегрузка оператора включения в поток
	friend ostream& operator<<(ostream& os, const Dog& d) {
 		return os <<"[" << d.nm << "]"; 
	} 
};
//===========================class DogHouse============================
class DogHouse {
	Dog* p; 
	string houseName; 
	public: 
	DogHouse(Dog* dog, const string& house) : p(dog), houseName(house) {}
		// Перегрузка копирующего конструктора 
	DogHouse(const DogHouse& dh) : p(new Dog(dh.p, " copy-constructed")),
						houseName(dh.houseName + " copy-constructed") {}
		// Перегрузка оператора присваивания
	DogHouse& operator=(const DogHouse& dh) {
	 if(&dh != this) {// проверка на самоприсваивание
		 p = new Dog(dh.p, " assigned");
		 houseName = dh.houseName + " assigned"; 
		} 
	return *this; 
	} 
	void renameHouse(const string& newName) {
		 houseName = newName; 
	} 

	Dog* getDog() const  { return p; }
	//Перегрузка деструктора
	~DogHouse() { delete p; }
	//Перегрузка оператора включения в поток
	 friend ostream& operator<<(ostream& os, const DogHouse& dh) {
		 return os << "[" << dh.houseName << "] contains " << *dh.p;
	 } 
};
//======================функция main()===============================	
	int main() {
		DogHouse fidos(new Dog("Fido"), "FidoHouse");
		cout << fidos << endl;
		DogHouse fidos2 = fidos; // Конструирование копии 
		cout << fidos2 << endl; 
		fidos2.getDog()->rename("Spot"); 
		fidos2.renameHouse("SpotHouse");
		cout << fidos2 << endl; 
		fidos = fidos2; // Присваивание 
		cout << fidos << endl; 
		fidos.getDog()->rename("Max"); 
		fidos2.renameHouse("MaxHouse");
		system("pause");
	} 
/*
 Из листинга видно, что при выводе информации функции класса не обращаются
 к этой информации напрямую, а посылают *this в cout. В свою очередь, это 
 приводит к вызову функции operator<< для ostream. 
 Если нам потребуется изменить формат вывода данных Dog (добавить вывод 
 символов "[" и "]" в приведенном примере), изменения достаточно внести 
 только в одном месте.

Функция operator= выполняет проверку на самоприсваивание, чтобы объект 
не удалил сам себя.
*/
