#include<iostream>
#include<conio.h>
using namespace std;

int main()
{
    bool prime;
    int test;
    for(int i = 2; i < 100; i++){
        prime = true;
        for(int j = 2; j <= i/2; j++){
            if(i%j == 0){
                prime = false;
                break;
            }
        }
        if(prime == true){
            test = 13195;
            while(test%i == 0){
                test /= i;
            }
            bool prime2 = true;

            for(int j =  2; j <= test-1; j++)
            {
                if(test%j == 0)
                {
                    prime2 = false;
                    break;
                }
            }
            if(prime2 == true)
            {
                cout << test << endl;
            }
        }
    }
}
