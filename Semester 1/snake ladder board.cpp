#include<iostream>
#include<stdlib.h>
#include<conio.h>

using namespace std;


int main()
{
    char c;
    int x, y, num_block;
    int var_x;
        for(y = 0; y <= 20; y++){
                if(y%2 == 0)
                    var_x = 30;
                else
                    var_x = 20;
            for(x = 0; x <= var_x; x++){
                if(x%2 == 0 || y%2 == 0)
                    cout << "\xb1";
                else if(x == 1 && x == 30)
                    cout << "\xb1";
                else{
                    num_block = (x + 191 - 10*y)/2;
                    if(num_block < 10)
                        cout << 0;
                    cout << num_block;
                }
            }
            cout << endl;
        }
}
