//���� TStack2.h 
//��������� ����� Stack2 
//� ��������� ������������� ������� ���������� 
#ifndef TSTACK2_H 
#define TSTACK2_H
template<class T> class TStack2 {
 struct Link { 
	 T* data;
	 Link* next;
	 Link(T* dat, Link* nxt): data(dat),next(nxt){} 
 }* head; 
public: TStack2() : head(0) {} 
		~TStack2 () ;
		//��������� � ���� ��������� �� ������
		void push(T* dat) {
			head = new Link(dat,head);
		}
		//������ ����������� ������� �����
		T* peek() const {
			return head ? head->data : 0;
		} 
		//���������� ������� �� ����� � ������������� ������
		T* pop(); 
		// ��������� ������������� ����� ���������: 
		class iterator; // ���������� ���������� 
		friend class iterator; // ������������� ����� 
		class iterator { // ������ ����� ���������� 
				Link * p;
		public: iterator (const TStack2<T> &ti) : p(ti.head) {} 
				// ���������� �����������: 
				iterator(const iterator& ti) : p(ti.p) {} 
				// �������� ��������: 
				iterator() : p(0) {} 
// operator++ �������� �������� � ���������� ���������� ������� ����� ������������������:
		//(����������� � ���������� ++ ��� ���������� � STL ����������� ���������)
//----------------------------------------------------------
				//����������� ���������:
				bool operator++() {
				if(p->next) 
					p = p->next;
				else 
					p = 0; // ������� ����� ������ 
				return bool(p); 
				} 
				 //���������� ���������:
				bool operator++(int) { return operator++(); }
//-----------------------------------------------------------
				T* current() const {
					if(!p) return 0; 
					return p->data;
				} 
			// ��������� ������������� ���������:			
//-----------------------------------------------------------
				T* operator->() const {return current();}

				T* operator*() const { return current(); }
//-----------------------------------------------------------
			// ��������� ��� �������� ������ � ����� ����������: 
				bool operator==(const iterator&) const {
					return p == 0;
				} 
				bool operator!=(const iterator&) const;/* {
					return p != 0;
				}*/
			};//����� �������� ������� ������ iterator
		
			iterator begin() const {
				return iterator(*this);
			} 
			iterator end() const { return iterator(); }
	};//����� �������� ������� ������ Stack2
//������� ���������� ��������� operator!=(const iterator&) const
 template<class T>  bool TStack2<T>::  iterator::  operator!=(const iterator&) const {
					return p != 0;
				}	 

	template<class T> TStack2<T>::~TStack2() {
		while(head) 
			delete pop();
	}
	template<class T> T* TStack2<T>::pop() {
		if(head == 0) return 0; 
		T* result = head->data; 
		Link* oldHead = head;
		head = head->next; 
		delete oldHead; 
		return result; 
	}
#endif // TSTACK2_H 