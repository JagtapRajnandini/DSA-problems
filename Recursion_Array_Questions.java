
public class Recursion_Array_Questions
{
public static void main(String[] args)
{
    int[] arr={1,2,3,5,689,7};
  //check_if_Array_is_sorted(arr, 0);
  System.out.println(linear_search(arr, 1, 0));
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

 return arr[i]==target || linear_search(arr,target,i+1);
}
}
