//ASCII Table
#include<iostream>
#include<conio.h>

int x, w;

int main()
{
    using std::cout;
    using std::cin;

    for(x = 0 ; x < 256; x++)
    {
        cout << x << ". ";
        cout << (char)x << "\n";
    }
    do
    {
        cout << "\n\n\nsearch ASCII by entering any number from 0-255:\t";
        cin >> w ;
        cout << "\n\t\t\t\t\t\t " << (char)w << "\n";
    }while(w != 256);
    return 0;
}
