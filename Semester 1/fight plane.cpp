#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<windows.h>
using namespace std;

struct coord
{
    int x;
        int y;
};
int main()
{
    const int MAX = 20;
    coord player ={5,5};
    coord bullet ={0,0};
    bool bullet_fire = false;
    bool change = false;
    char key;

    while(true)
    {
        switch(key)
        {
        case 'w':
            if(player.y > 1)
                player.y--;
            change = true;
            break;
        case 's':
            if(player.y < MAX)
                player.y++;
            change = true;
            break;
        case 'a':
            if(player.x > 1)
                player.x--;
            change = true;
            break;
        case 'd':
            if(player.x < MAX)
                player.x++;
            change = true;
            break;
        case ' ':
            if(bullet_fire == false){
                bullet.x = player.x;
                bullet.y = player.y;
                bullet_fire = true;
            }
            break;
        }
        if(change == true || bullet_fire == true){
            system("CLS");
            for(int y = 1; y <= MAX; y++){
                for(int x = 1; x <= MAX; x++){
                    if(x == player.x && y == player.y){
                        cout << "_^_";
                    }
                    else if(x == bullet.x && y == bullet.y){
                        cout << " .";
                    }
                    else{
                        cout << " ";
                    }
                }
                cout << endl;
            }
            change = false;
        }

//        if(bullet_fire == true)
//        {
//            Sleep(50);
//        }
        bullet.y--;
        if(bullet.y == -1)
        {
            bullet_fire = false;
            bullet = {0,0};
        }
        key = '\0';
        if(kbhit())
            key =  getch();
    }
}
