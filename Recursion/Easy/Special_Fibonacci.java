/*
https://www.codechef.com/problems/FIBXOR01/

Sankalp recently learned Fibonacci numbers and now he is studying different algorithms to find them. 
After getting bored of reading them, he came with his own new type of numbers. He defined them as follows:

 f(0) = a;
 f(1) = b;
 f(n) = f(n-1) ^ f(n-2);  when n>1, where ^ denotes the bitwise xor operation.
You are given three integers a,b and n , calculate f(n).

Input

The input contains one or more independent test cases.

The first line of input contains a single integer T (1≤T≤103), the number of test cases.

Each of the T following lines contains three space-separated integers a, b, and n (0≤a,b,n≤109) respectively.

Output

For each test case, output f(n).

Constraints
\(1<=T<=1000\)
\(0<=a,b,n<=10^9\)
Sample Input
4
86 77 15
93 35 86
92 49 21
62 27 90

Sample Input
86
126
92
62
*/

package Recursion.Easy;

public class Special_Fibonacci 
{
    public static void main(String[] args)
    {
        int a=93;
        int b=35;
        int n=86;
        System.out.println(specialFibbo2(a, b, n));
    }

    private static int specialFibbo1(int a, int b, int n)
    {
        if(n==0)return a;
        if(n==1)return b;
        return specialFibbo1(a, b, n-1) ^ specialFibbo1(a, b, n-2);
    }

    private static int specialFibbo2(int a, int b, int n)
{
    // First few terms are:
    // f(0)=a, f(1)=b, f(2)=a^b,
    // f(3)=a, f(4)=b, f(5)=a^b ...
    // Since XOR cancels equal values (x ^ x = 0), the sequence repeats every 3 terms.
    // Hence, the answer depends only on n % 3.

    if (n % 3 == 0) return a;      // Returns f(0), f(3), f(6), ...

    if (n % 3 == 1) return b;      // Returns f(1), f(4), f(7), ...

    return a ^ b;                  // Returns f(2), f(5), f(8), ...
}
}
