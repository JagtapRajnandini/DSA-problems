package Array.SlidingWindow;

public class Max_Sum_Subarray_Of_Size_K
{
    public static void main(String[] args)
    {
        int[] arr={2,5,1,8,2,9,1};
        System.out.println(Solution(arr, 3));
    }

    static int Solution(int[] arr, int K)
    {
        int i=0;
        int j=0;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int l=arr.length;
        while( j<l )
        {
            sum+=arr[j];
            if(j-i+1 < K) j++;

            else if (j - i + 1 == K) 
            {
                maxSum = Math.max(maxSum, sum);
                // Remove first element of window
                sum -= arr[i];
                i++;
                j++;
            }

        
        }
        return maxSum;
    }

}