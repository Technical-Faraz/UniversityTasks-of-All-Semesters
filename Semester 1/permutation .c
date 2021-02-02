//find the permutation of two dices that there sum will be equal to "total"
#include<stdio.h>

int dots_dice1, dots_dice2, number;
int total;

int main(void)
{
    number = 0;
    printf("\nEnter the total sum of two dices through which we can make permutations (sum < 12) : \t");
    scanf("%d", &total);
    while( total > 12)
    {
        printf("\nSorry two dices having maximum six dots can't make the sum to %d", total);
        printf("\nAgain enter the sum but must be less than 12\n\n");
        scanf("%d", &total);
    }
    for(dots_dice1 = 1; dots_dice1 <= 6; dots_dice1++)
    {
        for(dots_dice2 = 1; dots_dice2 <= 6; dots_dice2++)
        {
            int tol = total;
            tol = dots_dice1 + dots_dice2;
            if(tol == total)
            {
            number++;
            printf("\n%d permutation is : %d + %d\n", number, dots_dice1, dots_dice2);
            }
        }
    }
    return 0;
}
