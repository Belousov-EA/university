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
 a + 1; // ������ �������� ���������� � Number 
// 1 + a; // ������! ������ �������� �� ��������� � ���� Number 
 a - b; // �� 
 a - 1; // ������ �������� ���������� � Number 
 1 - a; // ������ �������� ���������� � Number 
} 
