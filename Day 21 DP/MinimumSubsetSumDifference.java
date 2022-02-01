//Partition a set into two subsets such that the difference of subset sums is minimum
// Input:  arr[] = {1, 6, 11, 5} 
// Output: 1
// Explanation:
// Subset1 = {1, 5, 6}, sum of Subset1 = 12 
// Subset2 = {11}, sum of Subset2 = 11   
public class MinimumSubsetSumDifference 
{
	
 
	public static int MinSumDiff(int a[],int n)
	{
		 int sum = 0;
	        for (int i = 0; i < n; i++)
	            sum += a[i];
	        boolean dp[][]=subset(a,sum);
	        
	        int diff = Integer.MAX_VALUE;
	        
	        for (int j = sum / 2; j >= 0; j--) {
	            // Find the
	            if (dp[n][j] == true) {
	                diff = sum - 2 * j;
	                break;
	            }
	        }
	        return diff;
	        
	 
	}
	public static boolean[][] subset(int a[],int sum)
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
		
		return dp;
	
	}
	
	public static void main(String[] args) 
	{
		int a[]= { 1,6,11,5 };

		System.out.println(MinSumDiff(a,a.length));
	}

}
