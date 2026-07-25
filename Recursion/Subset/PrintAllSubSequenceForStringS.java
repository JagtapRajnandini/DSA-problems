package Recursion.Subset;
import java.util.List;
import java.util.ArrayList;
public class PrintAllSubSequenceForStringS
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        
        System.out.println(printSubSequence3("abc",""));
    }

    public static void  printSubSequence1(String unprocessed, String processed, List<String> ans)
    {
        /*
            Time Complexity: O(n × 2^n)
            There are 2^n subsets.
            Constructing each subset takes up to O(n) because of processed + unprocessed.charAt(0), which creates a new String.
            Auxiliary Space (recursion stack): O(n)
            Output Space: O(n × 2^n) to store all subsets.
        */
        if(unprocessed.isEmpty())
        {
            ans.add(processed);
            return ;
        }
        printSubSequence1(unprocessed.substring(1), processed+unprocessed.charAt(0), ans);
        printSubSequence1(unprocessed.substring(1), processed, ans);

    }

    public static List<String>  printSubSequence2(String unprocessed, String processed, List<String> ans)
    {
        /*
            Time Complexity: O(n × 2^n)
            There are 2^n subsets.
            Constructing each subset takes up to O(n) because of processed + unprocessed.charAt(0), which creates a new String.
            Auxiliary Space (recursion stack): O(n)
            Output Space: O(n × 2^n) to store all subsets.
        */
        if(unprocessed.isEmpty())
        {
            ans.add(processed);
            return ans;
        }
        printSubSequence2(unprocessed.substring(1), processed+unprocessed.charAt(0), ans);
        printSubSequence2(unprocessed.substring(1), processed, ans);

        return ans;
        
    }

    public static List<String> printSubSequence3(String unprocessed, String processed)
    {
        /*
            Time Complexity: O(n × 2^n)
            There are 2^n subsets.
            Constructing each subset takes up to O(n) because of processed + unprocessed.charAt(0), which creates a new String.
            Auxiliary Space (recursion stack): O(n)
            Output Space: O(n × 2^n) to store all subsets.
        */
       List<String> list=new ArrayList<>();
        if(unprocessed.isEmpty())
        {
            list.add(processed);
            return list;
        }
         List<String> listL=printSubSequence3(unprocessed.substring(1), processed+unprocessed.charAt(0));
         List<String> listR=printSubSequence3(unprocessed.substring(1), processed);
      
        listL.addAll(listR);
        list=listL;
        return list;
    }
}
