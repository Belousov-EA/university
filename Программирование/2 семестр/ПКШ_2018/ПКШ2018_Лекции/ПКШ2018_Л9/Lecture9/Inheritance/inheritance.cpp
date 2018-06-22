//L9:Inheritance.��� 
// ������� ������������ 
#include "..\\UsefulClass\\Useful.h" 
#include <iostream> 
using namespace std;
class Y : public X {
 int i; // ���������� i ������� �� i ������ X
 public: 
	 Y() {i = 0;}
 int change() {
 i = permute(); // ����� �� ������� �����
 return i; 
 } 
 void set(int ii) {
 i = ii;
 X::set(ii); // ����� �� ���� �� ����� 
 } 
};

int main() {
 cout << "sizeof(X) = " << sizeof(X) <<endl;
 cout << "sizeof(Y) = " << sizeof(Y) << endl;
 Y D;
 D.change(); // ��������� � ���������� ������� X:
 D.read();
 D.permute();//���������������� ������� �������� ������� ������:
 D.set(12);
 system("pause");
} 
/*����� Y ��������� �� X; ��� ��������, ��� Y �������� ��� 
���������� ������ X, � ����� ��� �������. ���������� Y �������� 
��������� X ����� ��� ��, ��� ���� �� �� ������� ������ X ������ Y,
������ ���� ����� ����������� �� X.
*/
