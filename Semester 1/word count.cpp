#include<iostream>
#include<conio.h>
using namespace std;

int main()
{
    bool word = false;
    char ch = 'a';
    int wordcount = 0, letter =0;

    cout << "Enter a phrase :\n";
    do{
        ch = getche();
        letter++;
        if(ch ==' ' || ch == '\r'){
            if(word == true){
                wordcount++;
                word = false;
            }
            letter--;

        }
        else
            if(word == false){
            word = true;
        }
    }while(ch != '\r');
    cout << "\nWord count is " << wordcount << "..\n";

    cout << "\nletter count is " << letter << "..\n";
}
