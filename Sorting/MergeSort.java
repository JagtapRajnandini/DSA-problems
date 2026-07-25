package Sorting;
import java.util.Arrays;
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr={5,7,2,3,4,1,6};
        solution2(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static int[] solution1(int[] arr)
    {
        // Divide the array into two halves until each subarray has only one element.
        // Each recursive call creates a new stack frame and works on a smaller part of the array.
        if(arr.length==1)
        {
            return arr;
        }

        int mid=arr.length/2;

        int[] left=solution1(Arrays.copyOfRange(arr, 0, mid));
        int[] right=solution1(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second)
    {
        // Merge the two sorted halves into a single sorted array.
        int l1=first.length;
        int l2=second.length;
        int[] ans=new int[l1+l2];
        int i=0;
        int j=0;
        int k=0;
        // Compare elements from both halves and place the smaller one into the result array.
        while(i<l1 && j<l2 )
        {
            if(first[i]<second[j])
            {
                ans[k]=first[i];
                i++;
            }

            else
            {
                ans[k]=second[j];
                j++;
            }

            k++;
        }
        // Copy any remaining elements from the left half.
         while(i<l1)
         {
            ans[k]=first[i];
            i++;
            k++;
         }
         // Copy any remaining elements from the right half.
         while(j<l2)
         {
            ans[k]=second[j];
            j++;
            k++;
         }


        return ans;
    }

    public static void solution2(int[] arr, int start, int end) {

        // Base case: subarray has 0 or 1 element
        if (end - start <= 1) {
            return;
        }

        int mid = start + (end - start) / 2;

        // Sort left half
        solution2(arr, start, mid);

        // Sort right half
        solution2(arr, mid, end);

        // Merge both sorted halves
        mergeInplace(arr, start, mid, end);
    }

    private static void mergeInplace(int[] arr, int start, int mid, int end) {

        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        // Merge the two sorted halves
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }

        // Copy remaining elements of left half
        while (i < mid) {
            mix[k++] = arr[i++];
        }

        // Copy remaining elements of right half
        while (j < end) {
            mix[k++] = arr[j++];
        }

        // Copy merged array back into original array
        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }
}