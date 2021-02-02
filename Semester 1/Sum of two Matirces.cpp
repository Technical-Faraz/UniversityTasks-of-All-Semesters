#include<iostream>
#include<conio.h>
using namespace std;

const int row = 3, col = 3;

//declaring functions
int get_matrix(int matrix[row][col]);
int sum_matrix(int matrix1[row][col], int matrix2[row][col], int matrix[row][col]);
void disp_matrix(int matix[row][col]);

int main()
{
    int m1[3][3], m2[3][3];
    int m3[3][3];

    get_matrix(m1);
    get_matrix(m2);

    sum_matrix(m1, m2, m3);
    cout << "Matrix A = \n\n";
    disp_matrix(m1);
    cout << "Matrix B = \n\n";
    disp_matrix(m2);
    cout << "Matrix A + B = \n\n";
    disp_matrix(m3);
    getch();
}

//Functions definitions
int get_matrix(int mat[row][col]){

    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            cout << "Enter value for row " << i+1 << " and column " << j+1 << " = ";
            cin >> mat[i][j];
        }
    }

    cout << endl;
}

int sum_matrix(int mat1[row][col], int mat2[row][col] , int mat3[row][col]){

    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            mat3[i][j] = mat1[i][j] + mat2[i][j];
        }
    }

    cout << endl;
}

void disp_matrix(int mat[row][col]){

    for(int i = 0; i < row; i++){
        cout << "|\t";

        for(int j = 0; j < col; j++){
            cout << mat[i][j] << "\t";
        }

        cout << "|";
        cout << endl;
    }

    cout << endl;

}



