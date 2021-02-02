#include<iostream>
#include<conio.h>
using namespace std;

int main()
{
    char c;
    string word[20] = "";
    string wordf,  wordr;
    int i;
    int x = 1;

    cout << "Write any sentence :- \n";
    do{
        c = getche();
        if(c == ' ' || c == '\r'){
            x++;
        }
        if(c != ' ' && c != '\r'){
        word[x] += c;
        }
    }while(c != '\r');
    do{
        cout << "\n\nFind : ";
        cin >> wordf;
        for(i = 1; i <= x; i++){
            if(wordf == word[i]){
                break;
            }
        }
    }while(wordf != word[i]);

    cout << "\nReplace : ";
    cin >> wordr;
    for(i = 1; i <= x; i++){
            if(wordf == word[i]){
                word[i] = wordr;
            }
        }

    cout << endl;
    for(i = 1; i <= x; i++){
            cout << word[i] << " ";
    }
}
