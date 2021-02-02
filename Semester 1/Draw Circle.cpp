#include<iostream>
#include<stdlib.h>
using namespace std;
int main()
{
    for(double y = 0; y > -10; y -= 0.5){
        for(double x = 0; x < 10; x += 0.25){
            if(x*x+y*y-10*x+10*y+25 <= 0){
                cout << "2";
            }else{
                cout << " ";
            }
        }
        cout << endl;
    }
}
