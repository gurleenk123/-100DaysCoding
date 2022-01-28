//Recursive ,Memoization and Top down Dp Solution for Knapsack Problem
public class knapsack01 {

	public static void main(String[] args)
	{
		int val[] = { 60, 100, 120 };  
	    int wt[] = { 10, 20, 30 };  
	     
	    int W = 50; 
	    int N = val.length; 
	    //System.out.println(knapsack(wt,val,W,N));
	    //System.out.println(knapsackmemo(wt,val,W,N));
	    System.out.println(knapsackdp(wt,val,W,N));

	}

	//recursive solution O(2^n)
	private static int knapsack(int[] wt, int[] val, int w, int n) 
	{
		if(n==0 || w==0)
		{
			return 0;
		}
		if(wt[n-1] <= w)
		{
			return Math.max(val[n-1] + knapsack(wt,val,w-wt[n-1],n-1), knapsack(wt,val,w,n-1));
			
		}
		else 
			return knapsack(wt,val,w,n-1);
	}
	
	//memoization
	static int knapsackmemo(int wt[], int val[], int W,int N)
	{ 
	     
	  
	    int dp[][] = new int[N + 1][W + 1];
	    
	    for(int i = 0; i < N + 1; i++)  
	        for(int j = 0; j < W + 1; j++)  
	            dp[i][j] = -1;   
	     
	    return knapsack2(wt,val,W,N,dp);    
	}
	
	public static int knapsack2(int[] wt, int[] val, int w, int n,int dp[][])
	{
		 
		if(n==0 || w==0)
		{
			return 0;
		}
		if(dp[n][w]!=-1)
			return dp[n][w];
		if(wt[n-1] <= w)
		{
			return dp[n][w]= Math.max(val[n-1] + knapsack(wt,val,w-wt[n-1],n-1), knapsack(wt,val,w,n-1));
			
		}
		else 
			return dp[n][w]= knapsack(wt,val,w,n-1);
	}
	
	//top down approach dp
	public static int knapsackdp(int[] wt, int[] val, int w, int n)
	{
		int[][] dp=new int[n+1][w+1];
		
		//initiazation
		for(int i=0;i<n+1;i++)
			for(int j=0;j<w+1;j++)
				if(i==0 || j==0)
					dp[i][j]=0;
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<w+1;j++)
			{
				if(wt[i-1] <= j)
				{
					dp[i][j]=Math.max(val[i-1] + dp[i-1][j - wt[i-1] ], dp[i-1][j]);
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		
			
		}
		return dp[n][w];
	}

}
