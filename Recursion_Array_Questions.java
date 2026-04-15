import java.util.ArrayList;
public class Recursion_Array_Questions
{
public static void main(String[] args)
{
    int[] arr={1,2,3,5,689,7,2};
  //check_if_Array_is_sorted(arr, 0);
  //System.out.println(linear_search(arr, 1, 0));
  ArrayList<Integer> list=new ArrayList<>();
  System.out.println(findAllIndices(arr, 2, 0, list));
}

static boolean check_if_Array_is_sorted(int[] arr,int i)
{
  if(arr.length <= 1|| i==arr.length-1)
  {
    return true;
  }
  if(arr[i]>arr[i+1])
  {
    return false;
  }
  return check_if_Array_is_sorted(arr, i+1);
}

static boolean linear_search(int[] arr,int target,int i)
{
 if(i==arr.length)
 {
  return false;
 }
//either one of the statements should for finding the target is not the current one try for next 
 return arr[i]==target || linear_search(arr,target,i+1);
}
 
static ArrayList<Integer> findAllIndices(int[] arr, int target, int i, ArrayList<Integer> list) {
    if (i == arr.length) {
        return list;
    }
    if (arr[i] == target) {
        list.add(i);
    }
    return findAllIndices(arr, target, i + 1, list);
}
}
