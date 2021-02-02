#include<iostream>
#include<cmath>
using namespace std;
// Reiman Summation program
int main()
{
    double lowerLimit = .1;
    double higherLimit = 1;
    double area =0;
    double y = 0;
    for(double x = lowerLimit; x < higherLimit; x +=0.1){
        y = 2*x-pow(x,2);   //Equation
        area += 0.1*y;
    }
    cout << area;
}
