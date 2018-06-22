//файл TStack2.h 
//Шаблонный класс Stack2 
//с вложенным дружественным классом итератором 
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
		//занесение в стек указателя на объект
		void push(T* dat) {
			head = new Link(dat,head);
		}
		//чтение содержимого вершины стека
		T* peek() const {
			return head ? head->data : 0;
		} 
		//извлечение объекта из стека с освобождением памяти
		T* pop(); 
		// Вложенный дружественный класс итератора: 
		class iterator; // Необходимо объявление 
		friend class iterator; // Дружественный класс 
		class iterator { // Теперь можно определять 
				Link * p;
		public: iterator (const TStack2<T> &ti) : p(ti.head) {} 
				// Копирующий конструктор: 
				iterator(const iterator& ti) : p(ti.p) {} 
				// Конечный итератор: 
				iterator() : p(0) {} 
// operator++ изменяет итератор и возвращает логический признак конца последовательности:
		//(постфиксный и префиксный ++ для итераторов в STL реализуются одинаково)
//----------------------------------------------------------
				//постфиксный инкремент:
				bool operator++() {
				if(p->next) 
					p = p->next;
				else 
					p = 0; // Признак конца списка 
				return bool(p); 
				} 
				 //префиксный инкремент:
				bool operator++(int) { return operator++(); }
//-----------------------------------------------------------
				T* current() const {
					if(!p) return 0; 
					return p->data;
				} 
			// Операторы разыменования указателя:			
//-----------------------------------------------------------
				T* operator->() const {return current();}

				T* operator*() const { return current(); }
//-----------------------------------------------------------
			// Сравнение для проверки выхода в конец контейнера: 
				bool operator==(const iterator&) const {
					return p == 0;
				} 
				bool operator!=(const iterator&) const;/* {
					return p != 0;
				}*/
			};//конец описания шаблона класса iterator
		
			iterator begin() const {
				return iterator(*this);
			} 
			iterator end() const { return iterator(); }
	};//конец описания шаблона класса Stack2
//внешняя перегрузка оператора operator!=(const iterator&) const
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