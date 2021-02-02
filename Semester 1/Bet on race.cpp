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
    int moves[50][MAX];
    bool occupy = false;
    Sleep(1000);
    srand(time(NULL));
    for(int index = 0; index < MAX; index++){       //initializing coord of each player
        player[index].x = 1;
        player[index].y = index + 1;
    }
    for(int index1 = 0; index1 < 50; index1++){
            for(int index = 0; index < MAX; index++){

                system("CLS");
                moves[index1][index] = rand()%3;
                load++;
                cout << load << " out of 250";
            }
    }
    while(true){

            for(int index = 0; index < MAX; index++){       //for running
                player[index].x += moves[ct][index];
            }
            ct++;

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

    }
}

