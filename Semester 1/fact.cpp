#include<iostream>

using namespace std;

int main(){

    unsigned int numb;
    unsigned long fact=1;

    cout<<"Enter the number ";
    cin>>numb;
    for(int j=numb;j>0;j--)
        fact *=j;
    cout<<"Its factorial is: "<<fact;
}
