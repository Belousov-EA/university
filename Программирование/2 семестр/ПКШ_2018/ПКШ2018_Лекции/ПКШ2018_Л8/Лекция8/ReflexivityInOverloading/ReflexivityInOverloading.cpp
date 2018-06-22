//L8:ReflexivityInOverloading.cpp 
class Number { 
int i;
public: 
	Number(int ii = 0) : i(ii) {}
 const Number operator+(const Number& n) const {
 return Number(i + n.i); 
 }
friend const Number operator-(const Number&, const Number&); 
};
const Number operator-(const Number& n1, const Number& n2) {
 return Number(n1.i - n2.i); 
}
int main() { 
	Number a(47), b(11);
 a + b; // OK 
 a + 1; // Второй аргумент приводится к Number 
// 1 + a; // Ошибка! Первый аргумент не относится к типу Number 
 a - b; // ОК 
 a - 1; // Второй аргумент приводится к Number 
 1 - a; // Первый аргумент приводится к Number 
} 
