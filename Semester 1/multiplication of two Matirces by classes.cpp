#include<iostream>
#include<conio.h>
using namespace std;

const int row = 3, col = 3;

//declaring functions
int get_matrix(int matrix[row][col]);
int mul_matrix(int matrix1[row][col], int matrix2[row][col], int matrix[row][col]);
void disp_matrix(int matix[row][col]);

int main()
{
    int m1[3][3], m2[3][3];
    int m3[3][3] = {{0,0,0},{0,0,0}};

    get_matrix(m1);


    get_matrix(m2);

    mul_matrix(m1, m2, m3);
    cout << "Matrix A = \n\n";
    disp_matrix(m1);
    cout << "Matrix B = \n\n";
    disp_matrix(m2);
    cout << "Matrix A x B = \n\n";
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

int mul_matrix(int mat1[row][col], int mat2[row][col] , int mat3[row][col]){

    for(int m = 0; m < row; m++)
        for(int p = 0; p < row; p++){
            for(int n = 0; n < col; n++){
                mat3[m][p] += (mat1[m][n] * mat2[n][p]);
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



