#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<windows.h>
#include<cstdlib>
#include<ctime>
using namespace std;

struct coord
{
    int x;
    int y;
};

struct side
{
    bool top;
    bool bottom;
    bool left;
    bool right;
};
int main()
{
    HANDLE h = GetStdHandle(STD_OUTPUT_HANDLE);
    const int MAX = 10;
    coord player = {2,6};
    side push = {0,1,0,0};
    int xrand = 0, yrand = 0;
    while(true)
    {
        if(push.bottom == true)
        {
            player.x+=xrand;
            player.y-=yrand;
        }
        else if(push.top == true)
        {
            player.x-=xrand;
            player.y+=yrand;
        }
        else if(push.left == true)
        {
            player.x+=xrand;
            player.y+=yrand;
        }
        else if(push.right == true)
        {
            player.x-=xrand;
            player.y-=yrand;
        }
        if(player.x > MAX - 1)
        {
            player.x = MAX - 1;
        }
        else if(player.x < 2)
        {
            player.x = 2;
        }
        else if(player.y > MAX - 1)
        {
            player.y = MAX - 1;
        }
        else if(player.y < 2)
        {
            player.y = 2;
        }

        system("CLS");
//for display our game area
        for(int y = 1; y <= MAX; y++){
            for(int x = 1; x <= MAX; x++){
                if(x == player.x && y == player.y){
                    SetConsoleTextAttribute(h, 12);
                    cout << "O";
                    SetConsoleTextAttribute(h, 7);
                }
                else if(x == 1 || x== MAX || y == 1|| y == MAX)
                {
                    SetConsoleTextAttribute(h, 14);
                    cout << "\xB1";
                    SetConsoleTextAttribute(h, 7);
                }
                else{
                    cout << " ";
                }
            }
            cout << endl;
        }
        Sleep(100);

        if(player.x <= 2)
        {
            push = {0,0,1,0};
            srand(time(NULL));
            xrand = rand()%2 + 1;
            yrand = rand()%2 + 1;
        }
        else if(player.x >= MAX-1)
        {
            push = {0,0,0,1};
            srand(time(NULL));
            xrand = rand()%2 + 1;
            yrand = rand()%2 + 1;

        }
        else if(player.y >= MAX-1)
        {
            push = {0,1,0,0};
            srand(time(NULL));
            xrand = rand()%2 + 1;
            yrand = rand()%2 + 1;

        }
        else if(player.y <= 2)
        {
            push = {1,0,0,0};
            srand(time(NULL));
            xrand = rand()%2 + 1;
            yrand = rand()%2 + 1;
        }

    }
}
