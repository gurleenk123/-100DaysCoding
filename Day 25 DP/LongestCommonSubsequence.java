// LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
//  For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 

public class LongestCommonSubsequence 
{
	//recursive
	public static int lcs(char[] x ,char[] y,int n,int m)
	{
		//base case
		if(n==0 || m==0)
			return 0;
		
		//choice
		if(x[n-1] == y[m-1])
		{
			return 1 + lcs(x,y,n-1,m-1);
		}
		else
		{
			return Math.max(lcs(x,y,n,m-1), lcs(x,y,n-1,m));
		}
	}
	
	//Memoization = Recursive calls + matrix
	public static int lcsMemo(char[] x ,char[] y,int n,int m)
	{
        int dp[][] = new int[n + 1][m + 1];
	    
	    for(int i = 0; i < n + 1; i++)  
	        for(int j = 0; j < m + 1; j++)  
	            dp[i][j] = -1;
	    
	    if(n==0 || m==0)
			return 0;
		
		//choice
		if(x[n-1] == y[m-1])
		{
			 dp[n][m]= 1 + lcs(x,y,n-1,m-1);
		}
		else
		{
			dp[n][m]= Math.max(lcs(x,y,n,m-1), lcs(x,y,n-1,m));
		}
	    return dp[n][m];
	}
	
	//Bottom up= only matrix (tabulation)
	public static int lcsTabulation(char[] x ,char[] y,int n,int m)
	{
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<m+1;j++)
			{
				if(i==0 || j==0)
					dp[i][j]=0;
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(x[i-1]==y[j-1])
				{
					dp[i][j]= 1 + dp[i-1][j-1]; 
				}
				else
				{
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[n][m];
				
	}

	public static void main(String[] args) 
	{
		String s1 = "abcdgh";
	    String s2 = "abedfhr";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is: " + +
	                                lcsTabulation( X, Y, m, n ) );
		 
	}

}
