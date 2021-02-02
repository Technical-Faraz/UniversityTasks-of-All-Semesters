#include<iostream>
#include<conio.h>
#include<windows.h>
#include<cstdlib>
#include<ctime>
using namespace std;

int main()
{
    int limit;
    cout << "Size of array : ";
    cin >> limit;
    const int MAX = limit;

    int arr[MAX];
    int sorted[MAX];

    for(int i = 0; i < MAX; i++){
        cout << i+1 << ". ";
        cin >> arr[i];
    }

    for(int i = 0; i < MAX - 1; i++){
        for(int j = i + 1; j < MAX; j++){
            if(arr[i] > arr[j]){
                arr[i] += arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }
    }

    cout << "\n\n After sorting ";
    for(int i = 0; i < MAX; i++){
        cout << endl << i + 1 << ". "<< arr[i] ;
    }

}
