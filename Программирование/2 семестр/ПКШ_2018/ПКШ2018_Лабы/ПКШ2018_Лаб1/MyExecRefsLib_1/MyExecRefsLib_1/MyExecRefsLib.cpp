// MyExecRefsLib.cpp
#include <iostream>
#include "MathFuncsLib.h"
using namespace std;

int main()
{
    double a = 7.4;
    int b = 99;

    cout << "a + b = " <<
        MathFuncs::MyMathFuncs::Add(a, b) << endl;
    cout << "a - b = " <<
		MathFuncs::MyMathFuncs::Subtract(a, b) << endl;
	system("pause");
    exit(0);
}
