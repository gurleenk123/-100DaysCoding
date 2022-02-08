//Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.

// Examples : 
// Input:   str1 = "geek",  str2 = "eke"
// Output: 5
// Explanation: 
// String "geeke" has both string "geek" 
// and "eke" as subsequences.

// Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
// Output:  9
// Explanation: 
// String "AGXGTXAYB" has both string 
// "AGGTAB" and "GXTXAYB" as subsequences.

public class ShortestCommonSupersequence 
{

	public static int scs(char[] x,char[] y,int n,int m)
	{
		int l1=x.length;
		int l2=y.length;
		int lcslen=lcsTabulation(x,y,n,m);
		
		return (l1+l2-lcslen);
		
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

	public static void main(String[] args) 
	{
		String s1 = "geek";
        String s2 = "eeke";
        char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of SCS is: " + +
	                                scs( X, Y, m, n ) );
		

	}

}
