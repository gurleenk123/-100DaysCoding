public class Fibonacci 
{
	public static int fibo(int n)
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		
		return fibo(n-1) + fibo(n-2);
	}
  //1D memoization
  
	static  int []dp = new int [1000];
	public static int fibomemo(int n)
	{
		if(n==0 || n==1)
			return n;
		if(dp[n]!=0)
			return dp[n];
		
		else
		{
			dp[n]=fibo(n-1)+fibo(n-2);
			return dp[n];
		}
	}

	public static void main(String[] args) 
	{
		System.out.println(fibomemo(6));

	}

}
