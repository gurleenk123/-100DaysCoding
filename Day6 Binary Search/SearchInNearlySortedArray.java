//Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. 
//Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

//For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
public class SearchInNearlySortedArray 
{
	
	public static int func(int a[],int target)
	{
		int n=a.length;
		int si=0;
		int ei=n-1;
		while(si<=ei)
		{
			int mid=si+(ei-si)/2;
			if(a[mid]==target)
				return mid;
			if(mid > si && a[mid-1]==target)
				return mid-1;
			if(mid < ei && a[mid+1]==target )
				return mid+1;
			
			if(a[mid] < target)
				si=mid+2;
			else if( a[mid] > target)
				ei=mid-2;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,3,10,20,30,25};
		System.out.println(func(a,25));

	}

}
