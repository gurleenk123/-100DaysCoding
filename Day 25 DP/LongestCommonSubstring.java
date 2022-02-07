// Given two strings ‘X’ and ‘Y’, find the length of the longest common substring. 
// Input : X = “GeeksforGeeks”, y = “GeeksQuiz” 
// Output : 5 
// Explanation:
// The longest common substring is “Geeks” and is of length 5.

// Input : X = “abcdxyz”, y = “xyzabcd” 
// Output : 4 
// Explanation:
// The longest common substring is “abcd” and is of length 4.
public class LongestCommonSubstring 
{
	public static int lcs(char x[],char y[],int n,int m)
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
					dp[i][j]=0;
				}
			}
		}
		
		//returning max of dp
		int maxElement = 0;
		 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] > maxElement) {
                    maxElement = dp[i][j];
                }
            }
        }
 
        
        return maxElement;	
        
	}

	public static void main(String[] args)
	{
		String s1 = "abcdgh";
	    String s2 = "abcdfhr";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is: " + +
	                                lcs( X, Y, m, n ) );

	}

}
