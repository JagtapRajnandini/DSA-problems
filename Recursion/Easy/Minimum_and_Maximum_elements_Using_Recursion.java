/*
https://www.geeksforgeeks.org/dsa/recursive-programs-to-find-minimum-and-maximum-elements-of-array/

2.Minimum and Maximum elements Using Recursion
Last Updated : 24 Sep, 2025
Given an array of integers arr[], find the minimum and maximum elements in the array using recursion only. 
The first element of the output represents the minimum value, and the second element represents the maximum 
value in the array.

Examples:

Input: arr[] = [1, 4, 3, -5, -4, 8, 6]
Output: [-5, 8]
Explanation: -5 is the minimum and 8 is the maximum element in the array

Input: arr[] = [12, 3, 15, 7, 9]
Output: [3, 15]
Explanation: 3 is the minimum and 15 is the maximum element in the array
*/

package Recursion.Easy;
public class Minimum_and_Maximum_elements_Using_Recursion
{
    public static void main(String[] args)
    {
        int[] arr={1, 4, 3, -5, -4, 8, 6};
        int[] sol=ans(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        System.out.println("["+sol[0]+", "+sol[1]+"]");
    }

    private static int[] ans(int[] arr, int max, int min, int i)
    {
        if(i==arr.length) return new int[]{min, max};
        if(arr[i]>max) max = arr[i];
        if(arr[i]<min) min = arr[i];
        return ans(arr, max, min, i+1);
    }

}