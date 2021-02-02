#include<iostream>
#include<conio.h>
using namespace std;

int main()
{
    char dir = 'a';
    int x = 10, y = 10;

    cout << "Press Enter to exit\n";
    while(dir != '\r')
    {
        cout << "\n your location is " << x << ", " << y;
        cout << "\npress direction keys s w e n";
        dir= getche();
        if(dir == 'n')
            y--;
        else if(dir == 's')
            y++;
        else if(dir == 'e')
            x++;
        else if(dir == 'w')
            x--;
    }
}
