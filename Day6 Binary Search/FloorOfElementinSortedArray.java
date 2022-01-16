//Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. Write efficient functions to find floor of x.
public class FloorOfElementinSortedArray 
{
	
	public static int func(int a[],int value)
	{
		int n=a.length;
		int si=0;
		int ei=n-1;
		int res=-1;
		while(si<=ei)
		{
			int mid=si+(ei-si)/2;
			if(a[mid]==value)
				return a[mid];
			if(a[mid]< value)
			{
				res=a[mid];
				si=mid+1;
				
			}
			else if(a[mid] > value)
				ei=mid-1;
			
				
		}
		return res;
	}

	public static void main(String[] args) 
	{
		int a[]= {2,3,10,24,30};
		System.out.println(func(a,5));

	}

}
