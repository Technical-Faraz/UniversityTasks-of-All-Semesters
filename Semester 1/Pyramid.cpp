#include<iostream>
#include<conio.h>

using namespace std;

int main()
{
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= 2*n-1; j++)
        {
            if(j >= n-(i-1) && j <= n+(i-1))
            {
                cout << 0;
            }
            else
            {
                cout << " ";
            }
        }
        cout << endl;
    }
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= 2*n-1; j++)
        {
            if(j >= i && j <= ((2*n-1)+1) - i)
            {
                cout << 0;
            }
            else
            {
                cout << " ";
            }
        }
        cout << endl;
    }

}
