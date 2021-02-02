#include<iostream>
#include<conio.h>
#include<ctime>
#include<cstdlib>
using namespace std;

struct coord
{
    int x;
    int y;
};

class team
{
private:
    coord start;
    coord block[4];
    coord escape;

public:
    coord player[4];
    void init(int player_no, coord initial_value)       //Initial position in the group's home
    {
        player[player_no] = initial_value;
    }
//    team(coord intialize_player_location[4])
//    {
//        for(int index = 0; index < 4; index++)
//        {
//            player[index] = intialize_player_location[index];
//            block[index] = intialize_player_location[index];
//        }
//    }
    coord getcoord(int no)
    {
        return player[no];
    }

};

int main()
{
    team group[4];
    int min_x, max_x, min_y, max_y;
    bool plyr_ocpy;

    //Initialize the group's player block location
    int player = 0;
    for(int loc_group_4 = 0; loc_group_4 < 4; loc_group_4++){
        switch(loc_group_4){
        case 0:
            min_x = 2;  max_x = 3;
            min_y = 2;  max_y = 3;
            break;
        case 1:
            min_x = 9;  max_x = 10;
            break;
        case 2:
            min_x = 2;  max_x = 3;
            min_y = 9;  max_y = 10;
            break;
        case 3:
            min_x = 9;  max_x = 10;
            break;
        }
        for(int loc_comb_y = min_y; loc_comb_y <= max_y; loc_comb_y++){
            for(int loc_comb_x = min_x; loc_comb_x <= max_x; loc_comb_x++){
                    coord initial_coord = {loc_comb_x, loc_comb_y};
                    group[loc_group_4].init(player, initial_coord);
                    player++;
            }
        }
        player = 0;             //now again setting coordinates for players of another group
    }

    int moves=0;
    for(int move_token = 0; move_token <= moves; move_token++){
        for(int y = 1; y <= 11; y++){
            for(int x = 1; x <= 11; x++){
                    plyr_ocpy = false;
                for(int index1 = 0; index1 < 4; index1++){
                    for(int index2 = 0; index2 < 4; index2++){
                        if(group[index1].player[index2].x == x &&
                           group[index1].player[index2].y == y )
                           switch(index1){
                            case 0:
                                cout << "\x02"; plyr_ocpy = true; break;
                            case 1:
                                cout << "\x03"; plyr_ocpy = true; break;
                            case 2:
                                cout << "\x04"; plyr_ocpy = true; break;
                            case 3:
                                cout << "\x05"; plyr_ocpy = true; break;
                           }
                    }
                }
                if(plyr_ocpy == false){
                    if(x <= 4 && y <= 4 ||
                       x >= 8 && y <= 4 ||
                       x <= 4 && y >= 8 ||
                       x >= 8 && y >= 8)
                        cout << "\xDB";
                    else if(x == 6 && y == 6)
                        cout << "\x0f";
                    else if(x == 6 && (y <= 10 && y >= 2)||
                            y == 6 && (x <= 10 && x >= 2)||
                            (x == 10 || x == 3) && y == 7 ||
                            (x == 9 || x == 2) && y == 5 ||
                            (y == 10 || y == 3) && x == 7 ||
                            (y == 9 || y == 2) && x == 5)
                            cout << "\xB2";
                    else
                        cout << "\xB1";
                }
            }
            cout << endl;
        }
    }

    getch();
}
