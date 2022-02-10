//Given a sequence, find the length of the longest palindromic subsequence in it.
//As another example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subsequence in it
public class LongestPalindromicSubsequence 
{
	public static int lps(String a)
	{
		StringBuffer str=new StringBuffer(a);
		str.reverse();
		String st=new String(str);
		
		char[] x=a.toCharArray();
		char[] y=st.toCharArray();
		return lcsTabulation(x,y,x.length,y.length);
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
		String a="cbbd";
		System.out.println(lps(a));

	}

}
