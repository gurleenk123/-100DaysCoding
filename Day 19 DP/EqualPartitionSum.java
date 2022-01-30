//Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same. 

public class EqualPartitionSum 
{
	
	public static boolean equisum(int a[])
	{
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum+=a[i];
		}
		if(sum % 2==0)
			return subset(a,sum/2) ;
		
		else
			return false;
	}
	public static boolean subset(int[] a, int sum)
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
	

	public static void main(String[] args) 
	{

		int a[]= {1,5,11,5};
		System.out.println(equisum(a));
		
		//subsets would be {1,5,5} and {11}


	}

}
