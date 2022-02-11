//Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
import java.util.Arrays;

public class MatrixChainMultiplication 
{
	public static int MCM(int a[],int i,int j)
	{
		if(i>=j)
			return 0;
		
		int min= Integer.MAX_VALUE;
		for(int k=i;k<j;k++)
		{
			int tempans=MCM(a,i,k) + MCM(a,k+1,j) + a[i-1]*a[k]*a[j];
			
			if(tempans<min)
				min=tempans;
		}
		return min;
	}

	public static int MCMdp(int a[],int i,int j)
	{
		int[][] dp = new int[100][100];
		for (int[] row : dp)
		      Arrays.fill(row, -1);
		
		if(i==j)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		dp[i][j]=Integer.MAX_VALUE;
		for(int k=i;k<j;k++)
		{
			dp[i][j]=Math.min(dp[i][j], MCMdp(a,i,k) + MCMdp(a,k+1,j) + a[i-1]*a[k]*a[j]);
			
		}
		return dp[i][j];
	}
	
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,4 };
	
	 
	    System.out.println("Minimum number of multiplications is " + MCM(arr,1,arr.length-1));
	    System.out.println("Minimum number of multiplications is " + MCMdp(arr,1,arr.length-1));


	}

}
