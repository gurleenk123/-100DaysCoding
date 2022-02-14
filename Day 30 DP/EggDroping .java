//Problem statement: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:

// If egg breaks at ith floor then it also breaks at all greater floors.
// If egg does not break at ith floor then it does not break at all lower floors.
// Unbroken egg can be used again.

public class EggDroping 
{

	public static int drop(int e ,int f)
	{
		if(f==0 || f==1)
			return f;
		
		if(e==1)
			return f;
		int mn=Integer.MAX_VALUE;
		
		for(int k=1;k<=f;k++)
		{
			int temp=1 + Math.max(drop(e-1,k-1), drop(e,f-k));
			mn=Math.min(temp,mn);
		}
		return mn;
	}
	public static int dropMemo(int e,int f) 
	{
		
		int dp[][] = new int[e + 1][f + 1];
		 
        for (int i=0;i<=e;i++)
            for (int j=0;j<=f;j++)
                dp[e][f]=-1;
        return Eggdrop(e,f,dp);
	
	}
	public static int Eggdrop(int e ,int f,int dp[][])
	{
		if(f==0 || f==1)
			return f;
		
		if(e==1)
			return f;
		if(dp[e][f]!=-1)
			return dp[e][f];
		
		int mn=Integer.MAX_VALUE;
		
		for(int k=1;k<=f;k++)
		{
			int temp=1 + Math.max(drop(e-1,k-1), drop(e,f-k));
			mn=Math.min(temp,mn);
		}
		return dp[e][f] =mn;
	}
	public static void main(String[] args) 
	
	{
		System.out.println("Min attempts: "+ drop(2,4));
		System.out.println("MIN attempts : "+ dropMemo(2,4));
	}

}
