//Given a bitonic sequence of n distinct elements, write a program to find a given element x in the bitonic sequence in O(log n) time. 
//A Bitonic Sequence is a sequence of numbers that is first strictly increasing then after a point strictly decreasing.

public class SearchinBitonicArray 
{
	//binary search ascending
	public static int BSascending(int a[],int si,int ei,int x)
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

	//binary search descending
	public static int BSdescending(int a[],int si,int ei,int x)
	{
		while(si<=ei)
		{
			int mid=si+(ei-si)/2;
			
			if(a[mid]==x)
			{
				return mid;
			}
			else if(a[mid] < x)
				ei=mid-1;
			else
				si=mid+1;
		}
		return -1;
		
	}
	
	//return index of bitonic element
	public static int findbitonicPoint(int[] nums) 
    {
		int n=nums.length;
		
	    int l = 1,r = n-2;
	    
	    while(l <= r){
	        
	        int mid = l + (r-l)/2;
	        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
	            return mid;
	        }
	        else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1] ){
	            l = mid + 1;
	        }
	        else{
	            r = mid - 1;
	        }
	    }
	    return -1;
        
    }
	public static int searchElement(int a[],int target)
	{
		//bitonic element index
		int bi=findbitonicPoint(a);
		if(target==a[bi])
			return bi;
		
		int temp = BSascending(a, 0, bi - 1, target);
            if (temp != -1)
            {
                return temp;
            }
 
            else
            {
            return BSdescending(a,bi + 1, a.length - 1, target);
            }
	}
	
	public static void main(String[] args) 
	{
		

		int a[]= {1,3,8,12,4,2};
		System.out.println(searchElement(a,12));
	


	}

}
