//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

public class SubsetSum {

	public static void main(String[] args)
	{
		int arr[]= {3, 34, 4, 12, 5, 2};
		int sum=30;
		System.out.println(subset(arr,sum));
		
	}

	private static boolean subset(int[] a, int sum)
	{
		int n=a.length;
		boolean dp[][]=new boolean[n+1][sum+1];
		
		
		//intialization
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<sum+1;j++)
			{
				if(i==0)
					dp[i][j]=false;
				if(j==0)
					dp[i][j]=true;
			}
		}
		
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(a[i-1] <=j)
				{
					dp[i][j]=dp[i-1][j-a[i-1]] || dp[i-1][j];
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		
		return dp[n][sum];
		
		
		
		
	}

}
