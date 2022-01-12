//A child is running up a staircase with N steps, and can hop 1 step, 2 steps or 3 steps at a time. 
//Implement a method to count how many possible ways the child can run up to the stairs? You need to return number of possible ways W.


public class StaircaseProblem 
{

	public static int ways(int n)
	{
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		
		return ways(n-1)+ ways(n-2)+ways(n-3);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("no of ways to climb staircase of 4 is:"+ways(4));

	}

}
