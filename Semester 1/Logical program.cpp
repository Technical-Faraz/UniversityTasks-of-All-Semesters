#include<iostream>
#include<conio.h>
#include<iomanip>
using namespace std;

int main()
{
    short pol, san, fir;

    cout << "Police   Sanitation   Fire\n\n";
    for(pol = 1; pol <= 7; pol++){
        for(san = 1; san <= 7; san++){
            for(fir = 1; fir <= 7; fir++){
                if(pol != fir && pol != san && san != fir && pol%2 == 0 && pol+san+fir == 12){
                    cout << pol << setw(9) << san << setw(13) << fir << endl;
                }
            }
        }
    }
    getch();
}
