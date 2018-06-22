//L9:Inheritance.срр 
// Простое наследование 
#include "..\\UsefulClass\\Useful.h" 
#include <iostream> 
using namespace std;
class Y : public X {
 int i; // Переменная i отлична от i класса X
 public: 
	 Y() {i = 0;}
 int change() {
 i = permute(); // Вызов по другому имени
 return i; 
 } 
 void set(int ii) {
 i = ii;
 X::set(ii); // Вызов по тому же имени 
 } 
};

int main() {
 cout << "sizeof(X) = " << sizeof(X) <<endl;
 cout << "sizeof(Y) = " << sizeof(Y) << endl;
 Y D;
 D.change(); // Обращение к интерфейсу функций X:
 D.read();
 D.permute();//Переопределенные функции скрывают базовые версии:
 D.set(12);
 system("pause");
} 
/*Класс Y наследует от X; это означает, что Y содержит все 
переменные класса X, а также его функции. Фактически Y содержит 
подобъект X точно так же, как если бы вы создали объект X внутри Y,
вместо того чтобы наследовать от X.
*/
