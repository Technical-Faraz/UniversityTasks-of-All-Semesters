#include<iostream>
#include<conio.h>
#include<fstream>
using namespace std;

class data
{
private:
    float ob_mark;
    float t_mark;
    string name;
    float per;
    string grade;

public:
    data():t_mark(1100)        //constructor
    {}
    //definitions

    void getname(){
        cout << "Student name : ";
        cin >> name;
    }

    void marking(){
        do{
            cout << "Enter your obtained marks : ";
            cin >> ob_mark;
            if(ob_mark > 1100){
                cout << "total marks is 1100.\nAgain enter the marks.";
            }
        }while(ob_mark > 1100);
        per = ob_mark/t_mark * 100;
        if(per >= 80){
            grade = "A1";
        }
        else if(per >= 70){
            grade = "A";
        }
        else if(per >= 60){
            grade = "B";
        }
        else if(per >= 50){
            grade = "C";
        }
        else if(per >= 40){
            grade = "D";
        }
        else if(per < 40){
            grade = "FAIL";
        }

    }
    void disp(){
        cout << "\nName of Student : " << name;
        cout << "\nObtained marks : " << ob_mark;
        cout << "\nPercentage : " << per;
        cout << "\nGrade : " << grade << endl << endl;
    }

    bool large(data d2){
        if(per < d2.per)
            return false;
        else
            return true;
    }

};



int main()
{
    char opt;
    int ind = -1;
    int MAX_DATA = 100;
    data student[MAX_DATA];
    bool lg;        //have it highest percentage
    data high;      //1st position data

    //Getting DATA
    do{
            cout << endl;
        ind++;
        student[ind].getname();
        student[ind].marking();

        cout << "Enter another students data(y/n) : ";
        cin >> opt;
    }while(opt != 'n' && ind < MAX_DATA-1);
    cout << "\n\n\t\t\tRECORDS";

    for(int index = 0; index <= ind; index++){
        cout << "\nRecord # " << index+1 << endl;
        student[index].disp();
    }

    //1st position goes to

    for(int ind1 = 0; ind1 <= ind; ind1++){
        lg = true;
        for(int ind2 = 0; ind2 <= ind; ind2++){
            lg = student[ind1].large(student[ind2]);
            if(lg == false)
                break;
        }
        if(lg == true)
            high = student[ind1];
    }
    cout << "\n\n1st position goes to :\n";
    high.disp();

    ofstream file("Data.txt");
    for(int i = 0; i <= ind; i++){
        file.write(reinterpret_cast<char*>(&student[i]), sizeof(student[i]));
        file << endl;
    }

    getch();

}
