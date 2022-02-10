//Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e.,
//any i’th character in the two subsequences shouldn’t have the same index in the original string.
//Input: str = "aabb"
// Output: "ab"

// Input: str = "aab"
// Output: "a"
// The two subsequence are 'a'(first) and 'a' 
// (second). Note that 'b' cannot be considered 
// as part of subsequence as it would be at same
// index in both.
public class LongestRepeatingSubsequence
{
	public static int lrs(char[] x )
	{
		int n=x.length;
		int dp[][]=new int[n+1][n+1];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				if(i==0 || j==0)
					dp[i][j]=0;
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(x[i-1]==x[j-1] && i!=j)
				{
					dp[i][j]= 1 + dp[i-1][j-1]; 
				}
				else
				{
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[n][n];
				
	}


	public static void main(String[] args) 
	{
		String s1 = "aabebcdd";
	 
	 
	    char[] X=s1.toCharArray();
	
	 
	    System.out.println("Length of LRS is: " + +
	                                lrs( X) );
		
	}

}
