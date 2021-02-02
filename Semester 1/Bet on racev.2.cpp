#include<iostream>
#include<conio.h>
#include<windows.h>
#include<cstdlib>
#include<ctime>
using namespace std;

struct coord{
    int x;
    int y;
};

int main()
{
    HANDLE h = GetStdHandle(STD_OUTPUT_HANDLE);
    const int MAX = 5;
    int ct = 0, load =0;
    coord player[MAX];
    bool occupy = false;
    for(int i = 0; i < MAX; i++){
        player[i].x = 1;
        player[i].y = i+1;
    }

    while(true){

        system("CLS");
        for(int y = 1; y <= MAX; y++){
            for(int x = 1; x <= 50; x++){
                    for(int index = 0; index < MAX; index++){
                        if(player[index].x == x && player[index].y == y){
                            SetConsoleTextAttribute(h, index + 1);
                            cout << "\x02";
                            SetConsoleTextAttribute(h, 7);
                            occupy = true;
                            break;
                        }
                    }
                    if(occupy == false){
                        if(x == 50)
                            cout << "|";
                        else
                            cout << " ";
                    }
                    occupy = false;
            }
        cout << endl;
        }
        Sleep(1000);
        for(int index = 0; index < MAX; index++){       //for running
                player[index].x += rand() % 3;
            }
        ct++;
    }
}

