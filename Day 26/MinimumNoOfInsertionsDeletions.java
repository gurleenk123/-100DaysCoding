//Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2. 
//Input : 
// str1 = "heap", str2 = "pea" 
// Output : 
// Minimum Deletion = 2 and
// Minimum Insertion = 1
// Explanation:
// p and h deleted from heap
// Then, p is inserted at the beginning
public class MinimumNoOfInsertionsDeletions {

	public static void main(String[] args) 
	{
		String s1 = "heap";
        String s2 = "pea";
        char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	    minimumDelInsert(X,Y,m,n);
	    
	    

	}

	private static void minimumDelInsert(char[] x, char[] y, int n, int m) 
	{
		
		int len=lcsTabulation(x,y,n,m);
		
		System.out.println("Minimum Deletions:"+ (n-len));
		System.out.println("Minimum Insertions:"+ (m-len));
		
		
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
