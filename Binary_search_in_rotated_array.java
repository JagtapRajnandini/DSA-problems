
public class Binary_search_in_rotated_array
{
  public static void main(String[] args)
  {
    int[] arr={3,4,5,6,7,0,1,2};
    System.out.println(searchElement(arr, 7));
  } 
  static boolean searchElement(int[] arr,int target)
  {
    if (arr.length == 0) return false;
     //finding the pivot(Largest element)
     int s1=0;
     int e1=arr.length-1;
     int pivotIndex=-1;
     while(s1<=e1)
     {
        int mid=s1+(e1-s1)/2;
        if(mid<e1 && arr[mid]>arr[mid+1])
        {
          pivotIndex=mid;
          break;
        }
        else if(mid>s1 && arr[mid]<arr[mid-1])
        {
            pivotIndex=mid-1;
            break;
        }
        if(arr[s1]<=arr[mid])s1=mid+1;
        else e1=mid-1;
     }
     
     int s2=-1,e2=-1;
     if(pivotIndex==-1)
     {
        s2=0;
        e2=arr.length-1;
     }
     else if(arr[pivotIndex]==target)return true;
     else if(target >= arr[0])
     {
        s2=0;
       e2=pivotIndex-1;
        
     }
     else
     {
       s2=pivotIndex+1;
        e2=arr.length-1;
     }
    while(s2<=e2)
     {
        int mid=s2+(e2-s2)/2;
        if(arr[mid]==target)return true;
        else if(arr[mid]>target)e2=mid-1;
        else s2=mid+1;
     }
     return false;
    }
  }   


