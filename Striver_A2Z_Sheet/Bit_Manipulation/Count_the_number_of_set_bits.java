/*
Problem Statement: Given an integer n, return the number of set bits (1s) in its binary representation.
Example 1:
Input: 
n = 5
Output:
 2
Explanation: 
The binary representation of 5 is 101, which has 2 set bits.

Example 2:
Input: 
n = 15
Output: 
4
Explanation: 
The binary representation of 15 is 1111, which has 4 set bits.
*/

package Striver_A2Z_Sheet.Bit_Manipulation;

public class Count_the_number_of_set_bits 
{
    public static void main(String[] args)
    {
        System.out.println(Solution(6));
    }

    static int Solution(int n)
    {
        int count=0;
        while(n>0)
        {
            if( (n&1) == 1)count++;
            n>>=1;
        }
        return count;
    }
}
