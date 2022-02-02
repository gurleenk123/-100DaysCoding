//Count the no of subsets of given difference
// I/P
// a[]={1,1,2,3} ,diff=1
// O/P=3
// {1,1,2}{3} , {1,3}{1,2}, {1,3},{1,2}  = 3suubsets
public class CountNoOfSubsetsOfGivenDiff {

	public static void main(String[] args)

	{
		int a[]= {1,1,2,3};
		int diff=1;
		System.out.println(func(a,diff));
		

	}

	public static int func(int[] a, int diff) 
	{
		int sum=0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		
		int s1=(diff+sum)/2;
		
		return count(a,s1);
	}
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

