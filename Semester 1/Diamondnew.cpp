#include<iostream>
#include<conio.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    for(int y = 1; y <= n; y++){
        for(int x = 1; x <= 2*n-1; x++){
            if(x == n + (y - 1)*(-1) || x == n + (y - 1)*(1)){
                cout << 0;
            }
            else{
                cout << " ";
            }
        }
        cout << endl;
    }

    for(int y = n - 1; y >= 1; y--){
        for(int x = 1; x <= 2*n-1; x++){
            if(x == n + (y - 1)*(-1) || x == n + (y - 1)*(1)){
                cout << 0;
            }
            else{
                cout << " ";
            }
        }
        cout << endl;
    }
}
