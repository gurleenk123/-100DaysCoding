//Given two sequences, print the longest subsequence present in both of them. 
// Examples: 
// LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. 
// LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

public class PrintLCS 
{
	public static int[][] lcsTabulation(char[] x ,char[] y,int n,int m)
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
		return dp;
				
	}
	
	public static void printlcs(char[] x ,char[] y,int n,int m)
	{
		int dp[][]=lcsTabulation(x,y,n,m);
		int index=dp[n][m];
		int temp=index;
		//character array of same size as of lcs length
		char[] lcs=new char[index];
		
		int i=n,j=m;
		while(i > 0 && j > 0)
		{
			if(x[i-1] == y[j-1])
			{
				lcs[index-1]=x[i-1];
				i--;
				j--;
				index--;
			}
			else
			{
				if(dp[i][j-1] > dp[i-1][j])
				{
					j--;
				}
				else
				{
					i--;
				}
			}
		}
		System.out.print("LCS is:");
        for(int k=0;k<temp;k++)
            System.out.print(lcs[k]);
	
		
		
	}
	

	public static void main(String[] args) 
	{
		String s1 = "GMATE";
	    String s2 = "GPAT";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    printlcs(X,Y,m,n);
	    
	    

	}
	

}
