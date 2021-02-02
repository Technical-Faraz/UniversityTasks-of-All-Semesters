#include<iostream>
using namespace std;

int fib(int n);

int main()
{
    int x, answer;
    cout << "Enter the number of term to find its value.";
    cin >> x;

    answer = fib(x);
    cout << "\nanswer is :" << answer;
}

int fib(int n)
{
    if(n < 3)
    {
        return 1;
    }
    else
    {
        return (fib(n-2) + fib(n-1));
    }
}

