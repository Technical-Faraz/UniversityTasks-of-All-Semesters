#include<iostream>
#include<conio.h>
using namespace std;


int main()
{
    string pg, find_word, replace_word;
    cout << "Terminate your paragraph by using this '&' character and then press ENTER,\n\n\n";
    getline(cin, pg, '&');

    cout << "\nFind word to replace it : ";
    cin >> find_word;

    int sizeFW = find_word.size();
    int ch = pg.find(find_word);
    if(ch != -1){
        cout << "Word found!";
        cout << "\nReplace : ";
        cin >> replace_word;
        do{
            pg.replace(ch, sizeFW, replace_word);
            ch = pg.find(find_word);
        }while(ch != -1);
        cout << "You have changed your paragraph successfully!\n\n";
        cout << pg;
    }
    else
        cout << "\nThis word is not exist in your paragraph!";

    getch();

}
