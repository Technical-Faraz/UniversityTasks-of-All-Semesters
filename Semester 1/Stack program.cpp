#include<iostream>
#include<conio.h>
using namespace std;

const int MAX = 3;

class stacks
{
protected:
    int arr[MAX];
    int top;

public:
    stacks(): top(-1)
    {}
    void push(int v)
    {
        arr[++top] = v;
    }
    int pop()
    {
        cout << endl << arr[top--];
    }
};

class stacks2:public stacks
{
    public:
        int push(int v)
        {
            if(top == MAX - 1){
                cout << "Stack fulled completely\n";
                return -1;
            }
            else{
                stacks::push(v);
                return 0;
            }

        }
        void pop()
        {
            if(top == -1){
                cout << "\nYou have no val on stack";
            }
            else{
                stacks::pop();
            }
        }
};
int main()
{
    stacks2 s;
    int y, x;
    for(x = 0; x < 10 ; x++){
        cin >> y;
        x += s.push(y);
        if(y == 0)
            break;
    }
    for(int z = 0; z <= x ; z++){
        s.pop();
    }
}

