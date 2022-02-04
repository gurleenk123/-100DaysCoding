// Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. 
// Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length of the rod is 8 and the values of different pieces are 
// given as the following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 

// length   | 1   2   3   4   5   6   7   8  
// --------------------------------------------
// price    | 1   5   8   9  10  17  17  20

public class RodCuttingProblem {

	public static void main(String[] args) 
	{
		int len[]= {1,2,3,4,5,6,7,8};
		int price[]= {1,5,8,9,10,17,17,20};
		int n=len.length;
		System.out.println("Max profit is:"+rodCut(len,price,n,n));
		
		

	}

	public static int rodCut(int[] len, int[] price, int n,int max_len) 
	{
		int[][] dp=new int[n+1][max_len+1];
		
		for(int i=0;i<n+1;i++)
			for(int j=0;j<max_len+1;j++)
				if(i==0 || j==0)
					dp[i][j]=0;
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<max_len+1;j++)
			{
				if(len[i-1]<=j)
				{
					dp[i][j]=Math.max(price[i-1] + dp[i][j-len[i-1]], dp[i-1][j]);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][max_len];
		
		
	}

}
