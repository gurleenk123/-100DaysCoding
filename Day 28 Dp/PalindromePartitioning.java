//Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for a palindrome partitioning of a given string. For example, minimum of 3 cuts are needed for “ababbbabbababa”. 
//The three cuts are “a|babbbab|b|ababa”.

import java.util.Arrays;

public class PalindromePartitioning
{
	static boolean isPalindrome(String string, int i, int j)
	  {
	    while(i < j)
	    {
	      if(string.charAt(i) != string.charAt(j))
	        return false; 
	      i++;
	      j--;
	    }
	    return true;
	  }
	
	public static int func(String s,int i,int j)
	{
		if(i>=j || isPalindrome(s,i,j))
		{
			return 0;
		}
		int ans=Integer.MAX_VALUE,temp;
		for(int k=i;k<j;k++)
		{
			temp=func(s,i,k) + func(s,k+1,j) +1;
			ans=Math.min(temp,ans);
		}
		return ans;
		

	}
	
	public static int funcdp(String s,int i,int j)
	{
		int[][] dp = new int[100][100];
		for (int[] row : dp)
		      Arrays.fill(row, -1);
		
		if(i>=j || isPalindrome(s,i,j))
		{
			return 0;
		}
		int ans=Integer.MAX_VALUE,temp;
		int left=0,right=0;
		for(int k=i;k<j;k++)
		{
			if(dp[i][k]!=-1)
				left=dp[i][k];
			else
			{
				left=funcdp(s,i,k);
				dp[i][k]=left;
			}
			if(dp[k+1][j]!=-1)
				right=dp[k+1][j];
			else
			{
				right=funcdp(s,k+1,j);
				dp[k+1][j]=right;
			}
			temp=1+left+right;
			ans=Math.min(ans, temp);
			
		}
		return ans;
	}
	

	public static void main(String[] args) 
	{
		String str = "geek";
        System.out.println( funcdp(str,0,str.length()-1));
		

	}

}
