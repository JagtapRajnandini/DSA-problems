package Recursion.Easy;
public class SkipCharacterc
{
    public static void main(String[] args)
    {
        StringBuilder sb=new StringBuilder();
		System.out.println(skipCharc("Rajnandini Sampat Jagtap", 'a', 0, sb));

        sb.setLength(0);
        System.out.println(skipString("bacappledapplexyappleza", "apple", sb, 0));
    }

    public static String skipCharc(String s, char c, int i, StringBuilder sb)
	{
	    if(i==s.length())return sb.toString();
	    
	    if(s.charAt(i)!=c)sb.append(s.charAt(i));
	    
	    return skipCharc(s, c, i+1, sb);
	    
	}

    public static String skipString(String s, String skip, StringBuilder sb, int i)
{
    // Base case: Reached the end of the string.
    // Return the final string stored in StringBuilder.
    if(i == s.length()) return sb.toString();

    // If the current character is not the first character of the string to skip,
    // simply add it to the answer.
    if(s.charAt(i) != skip.charAt(0))
        sb.append(s.charAt(i));

    // Current character matches the first character of the string to skip.
    else if(s.charAt(i) == skip.charAt(0))
    {
        // Check:
        // 1. Enough characters are left in the string.
        // 2. The substring starting from index i is exactly equal to 'skip'.
        if(s.length() - i >= skip.length() &&
           s.substring(i, i + skip.length()).equals(skip))
        {
            // Skip the entire matching string by moving the index
            // to the character immediately after it.
            return skipString(s, skip, sb, i + skip.length());
        }
        else
        {
            // The current character is not part of the string to skip.
            // Add it to the answer and move to the next character.
            sb.append(s.charAt(i));
            return skipString(s, skip, sb, i + 1);
        }
    }

    // Continue checking the remaining characters.
    return skipString(s, skip, sb, i + 1);
}
}