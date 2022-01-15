public class NoOfTimesSortedArrayIsRotated 
{
	
	public static int func(int a[])
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

	public static void main(String[] args) 
	{
		//original array is 
		//a[]={2,5,6,8,11,12,15,18}
		int a[]= {11,12,15,18,2,5,6,8};
		System.out.println("No of times rotated is "+ func(a));

	}

}
