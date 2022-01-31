//Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

// Input: arr[] = {1, 2, 3, 3}, X = 6 
// Output: 3 
// All the possible subsets are {1, 2, 3}, 
// {1, 2, 3} and {3, 3}

// Input: arr[] = {1, 1, 1, 1}, X = 1 
// Output: 4 

public class CountNoOfSubsetsOfGivenSum 
{
	

	public static void main(String[] args) 
	{
		int a[]= { 3, 3, 3, 3 };
		int sum=6;
		//System.out.println(count(a,sum));
		System.out.println(countDP(a,sum));

	}
	
	//recursive + dp
	public static int count(int a[], int sum)
	{
		int N=a.length;
        int dp[][] = new int[N + 1][sum + 1];
	    
	    for(int i = 0; i < N + 1; i++)  
	        for(int j = 0; j < sum + 1; j++)  
	            dp[i][j] = -1;   
	     
	    return countmemo(a,sum,dp,N);  
		
	}


	private static int countmemo(int[] a, int sum, int[][] dp,int n) 
	{
		if(sum==0)
			return 1;
		if(n==0)
			return 0;
		if(dp[n][sum]!=-1)
			return dp[n][sum];
		
		if(a[n-1] <=sum)
			return dp[n][sum]=countmemo(a,sum-a[n-1],dp,n-1) + countmemo(a,sum,dp,n-1);
		
		else
			return dp[n][sum]=countmemo(a,sum,dp,n-1);
	
	}
	
	//bottom up approach iterative + dp
	private static int countDP(int[] a, int sum)
	{
		int n=a.length;
		int dp[][]=new int[n+1][sum+1];
		
		
		//intialization
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<sum+1;j++)
			{
				if(i==0)
					dp[i][j]=0;
				if(j==0)
					dp[i][j]=1;
			}
		}
		
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(a[i-1] <=j)
				{
					dp[i][j]=dp[i-1][j-a[i-1]] + dp[i-1][j];
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		
		return dp[n][sum];
		
		
		
		
	}

}
