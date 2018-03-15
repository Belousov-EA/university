 //file Stack.h
// Stack with the constructor and destructor
#ifndef STACK_H 
#define STACK_H
class Stack {
 	struct Link {
 	void* data;
	Link* next;
	Link(void* dat, Link* nxt);
	~Link(); 
	}* head; //pointer to the top 
public: 
	Stack();
	~Stack();
	void push(void* dat);
	void* peek();
	void* pop();
 };
#endif // STACK_H 
