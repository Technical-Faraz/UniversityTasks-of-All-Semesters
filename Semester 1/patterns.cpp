#include<iostream>
using namespace std;

int main()
{
    int x;
    cin>>x;

    for(int i = 1; i <= x; i++)
    {
        for(int j = 1; j <= x*2; j++)
        {
            if(j == 1 || i == 1 || j == x*2 || i == x)
                cout << "0";
            else
                cout << " ";
        }
        cout << endl;
    }
}
