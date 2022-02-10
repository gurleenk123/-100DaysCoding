//Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.
//Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".
public class MinimumDeletionsInStringToMakePalindrome 
{

	public static void main(String[] args) {
		String a="aebcbda";
		
		System.out.println("Minimum Deletions : " +mindel(a));

	}

	private static int mindel(String a)
	{
		int lenLPS=lps(a);
		
		return a.length()-lenLPS;
	}
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

}
