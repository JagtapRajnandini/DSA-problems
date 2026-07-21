/*
Problem Statement: Given two integers a and b, swap them in-place using only 2 variables (without using a temporary variable).
Example 1:
Input:
 a = 5, b = 10
Output:
 a = 10, b = 5

Example 2:
Input:
 a = -100, b = -200
Output:
 a = -200, b = -100
*/

package Striver_A2Z_Sheet.Bit_Manipulation;

public class Swap_two_numbers 
{
    public static void main(String[] args)
    {
        Solution(2,5);
    }   
    
    static void Solution(int a, int b)
    {
        // a = a ^ b
        // b = a ^ b = (a ^ b) ^ b = a      (because b ^ b = 0)
        // a = a ^ b = (a ^ b) ^ a = b      (because a ^ a = 0)
        // Final: a and b are swapped.
        
        System.out.println("Before Swapping:");
        System.out.println("a : " + a + " | b : " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After Swapping:");
        System.out.println("a : " + a + " | b : " + b);
    }
}
