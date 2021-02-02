#include<iostream>
#include<stdlib.h>
#include<windows.h>
#include<conio.h>
using namespace std;

int main()
{
    int x1=0,y1=1;
    int n =0;
    while(true){
        for(int t = 0; t <= n; t++){
            Sleep(1000);
            system("CLS");
            x1++;
            for(int y = 1; y<= 10; y++){
                for(int x = 1; x<= 10 ;x++){
                    if(x1 == 2 && x == x1){
                        cout << 9;
                    }
                    else if(x==x1&&y==y1)
                        cout << "0";
                    else
                        cout<<" ";
                }
                cout << endl;
            }
        }
        cout<<"enter the no of rows";
        cin>> n;
    }

}
