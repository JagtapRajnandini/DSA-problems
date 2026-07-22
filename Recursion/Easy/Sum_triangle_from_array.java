/*
https://www.geeksforgeeks.org/dsa/sum-triangle-from-array/

1.Sum triangle from array

Given an array of integers, print a sum triangle from it such that the first level has all array elements. 
From then, at each level number of elements is one less than the previous level and elements at the level is 
be the Sum of consecutive two elements in the previous level. 
Example :
Input : A = {1, 2, 3, 4, 5}
Output : [48]
         [20, 28] 
         [8, 12, 16] 
         [3, 5, 7, 9] 
         [1, 2, 3, 4, 5] 

Explanation :
Here,   [48]
        [20, 28] -->(20 + 28 = 48)
        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
*/

package Recursion.Easy;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_triangle_from_array
{
    public static void main(String[] args)
    {
        int[] arr={1, 2, 3, 4, 5};
        ans(arr, arr.length-1);
    }

    private static void ans(int[] arr, int end)
    {
        if(end==-1)return;
        List<Integer> list = Arrays.stream(arr, 0, end+1).boxed().toList();
        for(int k=0;k<list.size()-1;k++)
        {
            arr[k]=list.get(k)+list.get(k+1);
        }
        ans(arr, --end);
        System.out.println(list);
    }
}