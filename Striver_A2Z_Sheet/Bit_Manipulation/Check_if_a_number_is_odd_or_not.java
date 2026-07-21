/*
Problem Statement: Given a non-negative integer n, determine whether it is odd. Return true 
if the number is odd, otherwise return false. A number is odd if it is not divisible by 
2 (i.e., n % 2 != 0).

Example 1:
Input:
 n = 7
Output:
 true
Explanation:
 7 is not divisible by 2. Hence, it is odd.

Example 2:
Input:
 n = 10
Output:
 false
Explanation:
 10 is divisible by 2. Hence, it is not odd.
*/
package Striver_A2Z_Sheet.Bit_Manipulation;

public class Check_if_a_number_is_odd_or_not 
{
    public static void main(String[] args)
    {
        System.out.println(Solution(5));
    }

    static String Solution(int n)
    {

        if( (n&1) == 1 )return "ODD";
        return "EVEN";
    }
}
