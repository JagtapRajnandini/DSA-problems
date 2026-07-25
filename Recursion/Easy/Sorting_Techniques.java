package Recursion.Easy;
import java.util.Arrays;
public class Sorting_Techniques
{
    public static void main(String[] args)
    {
        int[] arr={7,2,5,1,6,4,3};
        //bubbleSort(arr, 0,0);
        selectionSort(arr, 0, 0, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }   
    
    static void bubbleSort(int[] arr, int i, int j) {
    if (i == arr.length - 1)
        return;

    if (arr[j] > arr[j + 1]) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    if (j == arr.length - i - 2) 
    {
        bubbleSort(arr, i + 1, 0);
    } 
    else 
    {
        bubbleSort(arr, i, j + 1);
    }
}

    static void selectionSort(int[] arr, int i, int j, int maxIndex, int last) {

    if (i == arr.length - 1)
        return;

    if (j > last) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[last];
        arr[last] = temp;

        selectionSort(arr, i + 1, 0, 0, last - 1);
        return;
    }

    if (arr[j] > arr[maxIndex]) {
        maxIndex = j;
    }

    selectionSort(arr, i, j + 1, maxIndex, last);
}
}
