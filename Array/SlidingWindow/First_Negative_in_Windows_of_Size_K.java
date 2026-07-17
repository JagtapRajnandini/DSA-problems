
//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1


/*
    Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Note: If a window does not contain a negative integer, then return 0 for that window.

Examples:

Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.
Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
Output: [-1, -1, -7, -15, -15, 0] 
Explanation:
Window [12, -1, -7] First negative integer is -1.
Window [-1, -7, 8] First negative integer is -1.
Window [-7, 8, -15] First negative integer is -7.
Window [8, -15, 30] First negative integer is -15.
Window [-15, 30, 16] First negative integer is -15.
Window [30, 16, 28] No negative integers, output is 0.
Input: arr[] = [12, 1, 3, 5] , k = 3
Output: [0, 0] 
Explanation:
Window [12, 1, 3] No negative integers, output is 0.
Window [1, 3, 5] No negative integers, output is 0.

Constraints:
1 <= arr.size() <= 106
-105 <= arr[i] <= 105
1 <= k <= arr.size()
*/

package Array.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class First_Negative_in_Windows_of_Size_K 
{
    public static void main(String[] args) 
    {
      int[] arr={12, -1, -7, 8, -15, 30, 16, 28};
      System.out.println(firstNegIntBruteForce(arr, 3));   
      System.out.println(firstNegInt(arr, 3));
    }
    

    static List<Integer> firstNegIntBruteForce(int[] arr, int k)
    {
        List<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        int l=arr.length;
        while(j<l)
        {
            if(j-i+1 < k)
            {
                j++;
            }

            else if(j-i+1 == k)
            {
                int n=i;
                boolean flag=false;
                while(n<=j)
                {
                    if(arr[n]<0)
                        {
                            ans.add(arr[n]);
                            flag=true;
                            break;
                        } 

                        n++;
                }
                if(!flag) ans.add(0);

                i++;
                j++;
            }
        }
        return ans;
    }

    static List<Integer> firstNegInt(int arr[], int k) 
    {
        List<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        int l=arr.length;
        Queue<Integer> queue = new LinkedList<>();
        while(j<l)
        {
            if(arr[j] < 0)
            {
                queue.offer(arr[j]);
            }
            if(j-i+1 < k)
            {
                j++;
            }
            else if(j-i+1 == k)
            {
                if(queue.isEmpty())
                {
                    ans.add(0);
                }
                else
                {
                    ans.add(queue.peek());
                    if(arr[i]<0)
                    {
                        queue.poll();
                    }
                    
                }

                i++;
                j++;
            }
        }
        return ans;
        
    }
}
