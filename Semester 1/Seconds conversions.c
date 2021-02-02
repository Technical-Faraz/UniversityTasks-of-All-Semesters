//illustrates the modulus operator.
// conversion of seconds into hours mins sec

#include<stdio.h>

#define SEC_MIN 60
#define SEC_H 3600

unsigned sec,min,h,sec_left,min_left;

int main(void)
{
    //input data

    printf("Enter number of seconds:");
    scanf("%d",&sec);
    getchar();
    //caculations
    h=sec/SEC_H;
    min=sec/SEC_MIN;
    min_left=min%SEC_MIN;
    sec_left=sec%SEC_MIN;

    printf("%u seconds is equal to ",sec);
    printf("%u hours, %u minutes, and %u s\n", h, min_left, sec_left);
    getchar();

    return 0;
}
