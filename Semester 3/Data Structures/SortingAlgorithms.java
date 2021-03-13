import javax.management.remote.JMXServerErrorException;
import java.util.Arrays;

public class SortingAlgorithms {

    public static int[] bubbleSort(int[] arr, char order){
        int temp;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - (i + 1); j++){
                if(order == 'a') {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                else{
                    if (arr[j] < arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr, char order){
        int temp;
        for(int i = 1; i < arr.length; i++){
            temp = arr[i];
            int count = i - 1;
            if(order == 'a') {
                while (count != -1 && temp < arr[count]) {
                    arr[count + 1] = arr[count];
                    count--;
                }
            }
            else{
                while (count != -1 && temp > arr[count]) {
                    arr[count + 1] = arr[count];
                    count--;
                }
            }
            arr[++count] = temp;
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr , char order){
        int length = arr.length;

        if(length < 2) return arr;

        int mid = length / 2;
        //Creating Sub arrays
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = mid; j < length; j++) {
            right[j - mid] = arr[j];
        }
        left = mergeSort(left, order);
        right = mergeSort(right,order);
        return merge(left, right, arr, order);
    }
    public static int[] merge(int[] L, int[] R, int[] arr, char order){
        int LPoint = 0, RPoint = 0, point = 0;
        while(LPoint < L.length && RPoint < R.length){
            if(order ==  'a') {
                if (L[LPoint] < R[RPoint]) {
                    arr[point++] = L[LPoint++];
                } else {
                    arr[point++] = R[RPoint++];
                }
            }
            else{
                if (L[LPoint] > R[RPoint]) {
                    arr[point++] = L[LPoint++];
                } else {
                    arr[point++] = R[RPoint++];
                }
            }
        }
        while(LPoint < L.length ){
            arr[point++] = L[LPoint++];
        }
        while(RPoint < R.length ){
            arr[point++] = R[RPoint++];
        }
        return arr;
    }

    public static void quickSort(int[] arr, int start, int end,  char order){
        int pIndex;
        if(start < end){
                pIndex = partition(arr,start,end, order);
                quickSort(arr, start, pIndex -1 , order);
                quickSort(arr, pIndex + 1, end, order);
        }
    }
    public static int partition(int[] arr, int start, int end, char order){
        int pIndex = start;
        int temp = arr[end];
        int aux;
        for(int i = start; i < end; i++){
            if(order == 'a') {
                if (arr[i] <= temp) {
                    aux = arr[i];
                    arr[i] = arr[pIndex];
                    arr[pIndex] = aux;
                    pIndex++;
                }
            }
            else{
                if (arr[i] >= temp) {
                    aux = arr[i];
                    arr[i] = arr[pIndex];
                    arr[pIndex] = aux;
                    pIndex++;
                }
            }
        }
        aux = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = aux;
        return pIndex;
    }
    public static void main(String[] args) {

        int[] arr = {3,4,1,8,6,5,0,2,7,13,15,18,19,10,9,11,14,20,16,12,17,20,28,23,21,30,22,26,25,27,29,24};
        int[] test = Arrays.copyOf(arr, arr.length);
        long init = System.nanoTime();
        bubbleSort(test, 'd');  //d for descending and a for ascending
        System.out.println("Total time taken by BubbleSort is " + (System.nanoTime() - init) + " nano secs" );
        for(int i : test){
            System.out.println(i + " ");
        }

        test = Arrays.copyOf(arr, arr.length);

        init = System.nanoTime();
        insertionSort(test, 'd');
        System.out.println("Total time taken by InsertionSort is " + (System.nanoTime() - init) + " nano secs" );
        for(int i : test){
            System.out.println(i + " ");
        }

        test = Arrays.copyOf(arr, arr.length);
        
        init = System.nanoTime();
        mergeSort(test, 'd');
        System.out.println("Total time taken by MergeSort is " + (System.nanoTime() - init) + " nano secs" );
        test = Arrays.copyOf(arr, arr.length);

        init = System.nanoTime();
        quickSort(test, 0 , test.length-1, 'd');
        System.out.println("Total time taken by QuickSort is " + (System.nanoTime() - init) + " nano secs" );

        for(int i : test){
            System.out.println(i + " ");
        }

        //According to output we found that InsertionSort is faster
        //1. Insertion sort
        //2. Quick Sort
        //3. Bubble Sort
        //4. Merge Sort
        // While we studied that merge sort is better because in the code it is using
        //implicit for loop in creating copy of another array
    }
}
