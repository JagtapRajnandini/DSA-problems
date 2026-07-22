/*
First uppercase letter in a string
Given a string find its first uppercase letter
Examples : 

Input : geeksforgeeKs
Output : K

Input  : geekS
Output : S
*/

package Recursion.Easy;

public class First_uppercase_letter_in_a_string 
{
    public static void main(String[] args)
    {
        System.out.println(sol("geeksforgeeks", 0));
    }


    private static char sol(String str, int i)
    {
        if(i==str.length())return '0';//If no uppercase character in string
        if(str.charAt(i)>='A' && str.charAt(i)<='Z') return str.charAt(i);
        return sol(str, ++i);
    }
}
