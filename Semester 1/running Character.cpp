#include<iostream>
#include<stdlib.h>
#include<conio.h>

using namespace std;

int main()
{
    int x=0, y=0;
    char mov;
    string ch;
    cout << "what is your name?";
    getline(cin, ch);
    system("CLS");
    cout << ch;
    do{
        mov = getch();
        if(mov == 'w')
        {
            system("CLS");
            y--;
            for(int c = 1; c <= y; c++)
                cout << "\n";

            for(int c = 1; c <= x; c++)
                cout << " ";

            cout << ch;
        }
        else if(mov == 'a')
        {
            system("CLS");
            x--;
            for(int c = 1; c <= y; c++)
                cout << "\n";

            for(int c = 1; c <= x; c++)
                cout << " ";

            cout << ch;
        }
        else if(mov == 's')
        {
            system("CLS");
            y++;
            for(int c = 1; c <= y; c++)
                cout << "\n";

            for(int c = 1; c <= x; c++)
                cout << " ";

            cout << ch;
        }
        else if(mov == 'd')
        {
            system("ClS");
            x++;
            for(int c = 1; c <= y; c++)
                cout << "\n";

            for(int c = 1; c <= x; c++)
                cout << " ";

            cout << ch;

        }
    }while(mov != 'e');
}
