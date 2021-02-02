//Conversion from decimal to other number systems
#include<iostream>
#include<conio.h>
#include<iomanip>

using namespace std;

int main()
{
    //Declaring varialbles
    int decimal, temp, num, opt, base;
    int ans[10];
    char hex;
    string os;

    cout << setw(70) << "* * * Made By Faraz Ahmed 19SW05 * * *\n";
    cout << setw(70) << "(Decimal to Other number system convertor)\n\n";//Show Menu
    do
    {
        cout << "\n1. Decimal to Binary \n";
        cout << "2. Decimal to Octal \n";
        cout << "3. Decimal to Hexadecimal \n";
        cout << "4. QUIT  \n";
        cout << "Choose any option you want and then press enter \n";
        cin >> opt;
    }while(opt > 4 || opt < 1);

    if(opt == 1)
    {
        os = "Binary";
        base = 2;
    }
        else if(opt == 2)
    {
        os = "Octal";
        base = 8;
    }
    else if(opt == 3)
    {
        os = "Hexadecimal";
        base = 16;
    }
    else
    {
        return 0;
    }
    cout << "\n\nInput any decimal value to convert it into " + os << "\t";
    cin >> decimal;

    //Calculations
    for(num = 0; decimal > base, num <= 10; num++)
    {
        temp = decimal / base;
        ans[num] = decimal % base;
        decimal = temp;
        if (decimal < base)         //For last value
        {
            ans[num + 1] = decimal;
        }
    }

    //Print values
    for(num = 10; num >= 0; num--)
    {
        if (ans[num] == 10 )
        {
            cout << "A";
        }else if (ans[num] == 11 )
        {
            cout << "B";
        }else if (ans[num] == 12 )
        {
            cout << "C";
        }else if (ans[num] == 13 )
        {
            cout << "D";
        }else if (ans[num] == 14 )
        {
            cout << "E";
        }else if (ans[num] == 15 )
        {
            cout << "F";
        }else
            cout << ans[num];
    }
    getch();
}
