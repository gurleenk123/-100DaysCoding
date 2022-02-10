public class SequencePatternMatching 
{
	

	public static void main(String[] args) 
	{
		String s1 = "axy";
	    String s2 = "adxcpy";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("s1 is lcs of s2 is :" + checkLCS(X,Y,m,n) );
		
	}

	private static boolean checkLCS(char[] x, char[] y, int m, int n) 
	{
		int lcsLen=lcsTabulation(x,y,m,n);
		if(lcsLen==x.length)
		{
			return true;
		}
		return false;
	
	}
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

}
