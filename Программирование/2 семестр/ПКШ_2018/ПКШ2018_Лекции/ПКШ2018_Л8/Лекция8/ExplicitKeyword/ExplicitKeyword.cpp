 /*���������� ������� ������������ ������ Two �� 
 ����������� ������� �������� ���:
 */
 //L8:ExplicitKeyword.��� 
 
 class One {
 public: One() {} 
 };
class Two {
 public: 
	 explicit 
		 Two(const One&) {} 
};
void f(Two) {}
int main() { 
	One one; 
//	f(one);// �������������� ���������� ���� ��������� 
	f(Two(one)); //����� - ���������� ���� ����������� �������������
} 
/*��������� ����������� Two � �������� ������ explicit, �� ���������
����������� ��������� �����-���� �������� �� ��������������� 
���������� ���� � �������������� ����� ����������� ������������ 
(������ ������������ ������, � ������� ����� explicit �����������, 
��-�������� ����� ��������������� ��� �������������� ��������������).
���� ������������ ����� ��������� ���������� ����, �� ������ ���� 
������� �� ��� �������������� � ���������. � ������������� ���������
����� f(Two(one)) ������� ��������� ������ ���� Two �� ������� one, 
��� ��� ����� ���������� � ���������� ������.
*/
