//L9:Order.срр 
// Порядок вызова конструкторов и деструкторов 
#include <fstream>
using namespace std; 
ofstream out("order.out");

template <class T>class T{	
public:
	int m;
	T(int n):m(n) {out <<typeid(this).name()<< " constructor\n";}
	~T(){out <<typeid(this).name()<< " destructor\n";}
};
class Base1;
class Member1;
class Member2;
class Member3;
class Member4;
class Derived1 : public T<Base1> { 
	T<Member1> m1; 
	T<Member2> m2; 
public: 
	Derived1(int n1=1,int n2=2) : m1(n1), m2(n2), T<Base1>(3) {
		out << "Derived1 constructor\n"; 
	} 
	~Derived1() {
 out <<" Derived1 destructor\n";
	} 
};
class Derived2 :public Derived1 { 
	T<Member3> m3; 
	T<Member4> m4;
public: Derived2() : m3(1), Derived1(2), m4(3) {
			out << "Derived2 constructor\n"; 
		} 
		~Derived2() {
			out << "Derived2 destructor\n"; 
		} 
};

int main() { 
	Derived2 d2; 
}
