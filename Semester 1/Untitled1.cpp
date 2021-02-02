#include<iostream>
#include<cstdlib>
#include<ctime>
#include<windows.h>
using namespace std;

int main()
{
    int x;
    while(true)
    {
        srand(time(NULL));
        x = rand()%2 + 1;
        cout << x << endl;
        Sleep(500);
    }
}
