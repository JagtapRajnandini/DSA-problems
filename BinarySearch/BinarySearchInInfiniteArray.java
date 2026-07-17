package BinarySearch;
// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

public class BinarySearchInInfiniteArray 
{
    public static void main(String[] args) 
    {
      int start=0;
      int end=1;
      int[] arr={2,3,5,6,7,8,10,11,12,15,20,23,30};
      System.out.println(ans(arr,15)); 
    }
    static int ans(int[] arr, int target) {
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while (target > arr[end]) {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);

    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
    /*public static int BinarySearch(int[] arr,int start, int end, int target)
    {
        findRange(start, end, arr, target);
        while(start<=end)
        {
            //int mid = (start + end) / 2; 
            // might be possible that (start + end) exceeds the range of int in java
            int mid=start+(end-start)/2;
            if(arr[mid]==target)return mid;
            else if(arr[mid]>target) end=mid-1;
            else if(arr[mid]<target) start=mid+1;      
        }
        return -1;
    }

    private static void findRange(int start,int end,int arr[],int target)
    {
        // first find the range
        // first start with a box of size 2
        start=0;
        end=1;
        while (arr[end]<target) 
        {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeofbox*2
            end=end+(end-start+1)*2;
            start=temp;
        }
    }*/
}
