#include<iostream>
#include<conio.h>
using namespace std;
//User-defined square root function using series
float pow(float base, float exp){
    float ans = 1;
    for(float i = 0; i < exp; i++){
        ans *= base;
    }
    return ans;
}

float fact(float x){
    float ans = 1;
    for(x ; x > 0; x--){
        ans *= x;
    }
    return ans;
}

float lnx(float x, float n){
    float ans = 0;
    for(float i = 1; i <= n; i++){
        ans += ((pow(-1, i+1))*(pow(x-1, i))/i);
    }
    return ans;
}

int main()
{
    float y = 10, s = 200;
    cout << lnx(y,s);
}
