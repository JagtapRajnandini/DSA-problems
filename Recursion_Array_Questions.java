
public class Recursion_Array_Questions
{
public static void main(String[] args)
{
    int[] arr={1,2,3,5,689,7};
  check_if_Array_is_sorted(arr, 0);
}

static void check_if_Array_is_sorted(int[] arr,int i)
{
  if(i==arr.length-1)
  {
    System.out.println("Array is sorted !!");
    return;
  }
  if(arr[i]>arr[i+1])
  {
    System.out.println("Array is not sorted !!");
    return;
  }
  check_if_Array_is_sorted(arr, i+1);
}
}
