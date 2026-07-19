/*
    Q. Will the discussed approach work with negative numbers in the array?
    A. No.

    This Variable Size Sliding Window approach works only when all array
    elements are non-negative.

    Reason:
    When the current window sum becomes greater than k, we shrink the window
    from the left because removing positive numbers always decreases the sum.

    If negative numbers are present, extending the window may decrease the
    sum again, so shrinking immediately can skip valid subarrays.

    Example:
    arr = [4,1,1,-2,1,5], k = 5

    Window: [4,1,1] -> sum = 6 (>5)

    Sliding Window shrinks the window here, but if we had continued
    expanding, we would get:

    [4,1,1,-2,1] -> sum = 5

    Hence this approach fails for arrays containing negative numbers.
*/

public class Longest_Subarray_Of_Sum_K
{
    public static void main(String[] args)
    {
        int[] arr={4, 7, 1, 2, 3, 5};
        int k=5;

        // Prints the length of the longest subarray having sum = k
        System.out.println(Solution(arr, k));
    }

    static int Solution(int[] arr, int k)
    {
        // Stores the maximum length of a valid subarray found so far
        int ans=0;

        // i -> Left pointer of the sliding window
        // j -> Right pointer of the sliding window
        int i=0;
        int j=0;

        // Length of the array
        int l=arr.length;

        // Stores the sum of the current window
        int sum=0;

        // Traverse the array using the right pointer
        while(j<l)
        {
            // Expand the window by including arr[j]
            sum+=arr[j];

            // Case 1:
            // Current window sum is smaller than k.
            // Expand the window by moving the right pointer.
            if(sum<k)
            {
                j++;
            }

            // Case 2:
            // Current window sum equals k.
            // Update the maximum window length and continue expanding.
            else if(sum==k)
            {
                ans=Math.max(ans, j-i+1);
                j++;
            }

            // Case 3:
            // Current window sum exceeds k.
            // Shrink the window from the left until
            // the sum becomes <= k.
            else
            {
                while(sum>k && i<=j)
                {
                    // Remove the leftmost element
                    sum-=arr[i];

                    // Move the left boundary forward
                    i++;
                }

                // After shrinking, check if we obtained the desired sum.
                if(sum==k)
                {
                    ans=Math.max(ans, j-i+1);
                }

                // Continue expanding the window
                j++;
            }
        }

        // Return the length of the longest valid subarray
        return ans;
    }
}