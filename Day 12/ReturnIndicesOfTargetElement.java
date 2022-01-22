// You are given an array and a number x. We are required to return an array with all the indices at which x occurs in an array.
// For example:
// Input: arr = {5, 3, 2, 3, 9, 7}, X = 3
// Output: {1, 3}
// Element 3 is present at indices 1 and 3.

public class ReturnIndicesOfTargetElement 
{
  //fsf is found so far element
  //used for checking the count of particular element
	public static int[] func(int a[],int target,int idx,int fsf)
	{
		if(idx==a.length)
		{
			return new int[fsf];
		}
		int ans[];
		if(a[idx]==target)
		{
			ans=func(a,target,idx+1,fsf+1);
			ans[fsf]=idx;
		}
		else
			ans=func(a,target,idx+1,fsf);
		
		return ans;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a[]= {10,2,4,2,5,6,2,3,2,9,2};
		int ans[]=func(a,2,0,0);
		for(int i=0;i<ans.length;i++)
		{
			System.out.print(ans[i]+" ");
		}

	}

}
