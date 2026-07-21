
/*
Problem Statement: Given a positive integer n, set the rightmost unset (0) bit of its binary 
representation to 1 and return the resulting integer.
If all bits are already set, return the number as it is.

Example 1:
Input:
 n = 10 (binary: 1010)  
Output:
 11 (binary: 1011)  
Explanation:
  The rightmost unset bit is the least significant bit (LSB). Setting it to 1 gives 1011 = 11.

Example 2:
Input:
 n = 7 (binary: 111)  
Output:
 7 (binary: 111)  
Explanation:
  All bits are already set to 1, so the number remains the same.
*/

package Striver_A2Z_Sheet.Bit_Manipulation;

public class Set_Unset_the_rightmost_bit 
{
    public static void main(String[] args)
    {
        System.out.println("Set Bit:"+SetBit(6));
        System.out.println("Unset Bit:"+UnsetBit(6));

    }   
    
    static int SetBit(int n)
    {
        return n|1 ;
    }

    static int UnsetBit(int n)
    {
        // Don't do: n & 0
        // Because AND with 0 makes every bit 0.
        // So the result is always 0, not just the rightmost bit.

        // Use: n & (~1)
        // 1 in binary is ...0001
        // ~1 becomes ...1110
        // ANDing with this mask keeps all bits the same
        // but changes only the rightmost bit to 0.

        // n & (-2) also works because
        // -2 is stored as ...1110 in two's complement.
        // So it has the same bit pattern as ~1.
        // It also clears only the rightmost bit.
        return n&(~1);
    }
}
