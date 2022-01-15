//Leetcode Q 33. Search in Rotated Sorted Array
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
public class FindElementinSortedRotatedArray 
{
	
	public static int binarysearch(int a[],int si,int ei,int x)
	{
		while(si<=ei)
		{
			int mid=si+(ei-si)/2;
			
			if(a[mid]==x)
			{
				return mid;
			}
			else if(a[mid] < x)
				si=mid+1;
			else
				ei=mid-1;
		}
		return -1;
		
	}
	
	public static int pivot(int a[])
	{
		int n=a.length;
		int si=0;
		int ei=n-1;
		while(si<=ei)
		{
			 if(a[si] <= a[ei])
	                return si;
			int mid=si+(ei-si)/2;
			int next=(mid+1)%n;
			int prev=(mid+n-1)%n;
			
			if(a[next] >= a[mid] && a[mid] <= a[prev])
				return mid;
			
			else if(a[mid] >= a[si])
				si=mid+1;
			else if( a[mid] <= a[ei] )
				ei=mid-1;
			
				
		}
		return -1;
	}
	public static int findElement(int a[],int target)
	{
		int len = a.length;
        int pivot = pivot(a );
        if(target>=a[pivot] && target<=a[len-1]){
            
            return binarysearch(a , pivot , len-1 , target);
        }
        else
            return binarysearch(a , 0 , pivot-1 , target); 
	}

	public static void main(String[] args) 
	{
		
		int a[]= {11,12,15,18,2,5,6,8};
		System.out.println("No of times rotated is "+ findElement(a,18));

	}

}
