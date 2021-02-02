#include<iostream>
using namespace std;

int main()
{
    unsigned long n, j;
    bool prime;
    for(n = 1; n <= 100; n++)
    {
        prime = true;

        for(j =  2; j <= n - 1; j++)
        {
            if(n%j == 0)
            {
                prime = false;
                break;
            }
        }
        if(prime == true)
        {
            cout << n << endl;
        }
    }
    return 0;
}
