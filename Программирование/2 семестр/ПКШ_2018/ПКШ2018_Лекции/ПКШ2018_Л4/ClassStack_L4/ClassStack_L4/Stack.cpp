// файл Stack.cpp 
// Конструкторы и деструкторы 
#include "Stack.h"
#include <iostream>
using namespace std;
Stack::Link::Link(void* dat, Link* nxt) {//только инициализация
	 data = dat;
	 next = nxt;
 }
Stack::Link::~Link() { }
Stack::Stack() {
	head = 0; 
}
void Stack::push(void* dat) {//выделение памяти и инициализация
	 head = new Link(dat, head); 
}//стек растет вверх (голова ссылается на предыдущее значение)
void* Stack::peek() { 
	if(head == 0){
		cout<<"Stack empty"<<endl; 
		return 0;
	}
 return head->data; 
}
void* Stack::pop() {
	 if(head == 0) 
		 return 0;
	 void* result = head->data;
	 Link* oldHead = head;
	 head = head->next;
	 delete oldHead;
	 return result; 
} 
Stack:: ~Stack() {
	 if(head != 0) 
		 cout<< "Stack not empty\n";
	 cout<< "Stack empty\n";
} 
