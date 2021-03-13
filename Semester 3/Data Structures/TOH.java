public class TOH {  //Tower Of Hanoi
    public static void solution(int n, char begin, char aux, char end){
        if(n >= 1){
            solution(n-1, begin, end, aux);
            System.out.printf("Move disk %d from rod %c to rod %c\n",n,begin,end);
            solution(n-1,aux,begin,end);
        }
    }

    public static void main(String[] args) {
        solution(64,'A','B','C');
    }
}
