//Given an array of integers sorted in ascending order, and a target value, find the element in the array that has minimum difference with the target value.
public class MinimumDifferenceElementinSortedArray 
{
	
	public static int func(int a[],int target)
	{
		int n = a.length;

        if (target < a[0])
            return a[0];
        if (target > a[n - 1])
            return a[n - 1];
        
        int si=0,ei=n-1;
        while(si<=ei)
        {

			int mid=si+(ei-si)/2;
			
			if(a[mid]==target)
			{
				return a[mid];
			}
			else if(a[mid] < target)
				si=mid+1;
			else
				ei=mid-1;
        }
        
        if(Math.abs(a[si]-target)< Math.abs(a[ei]-target))
        	return a[si];
        else
        	return a[ei];
        
	}

	public static void main(String[] args) 
	{
		int a[]= {1,3,8,10,15};
		System.out.println("minimum difference element from 12 is:"+func(a,12));

	}

}
