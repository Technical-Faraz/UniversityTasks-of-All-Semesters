#include<iostream>
#include<stdlib.h>
#include<conio.h>
using namespace std;

int main()
{
    int n;
    cout<<"enter the no of rows";
    cin>>n;
    for(int y = 1; y<= n; y++){
        for(int x = 1; x<= n ;x++){
            if(x==y||x+y==n+1)
            cout << "0";
            else
            cout<<" ";
        }
        cout << endl;
    }

}
