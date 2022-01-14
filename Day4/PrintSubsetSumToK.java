//Given an array of integers and a sum, the task is to print all subsets of the given array with a sum equal to a given sum.
public class PrintSubsetSumToK 
{
	
	public static void func(int a[],int target,int startindex,String ans,int sum)
	{
		if(startindex==a.length)
		{
			if(sum==target)
			{
				System.out.println(ans);
			}
			return;
		}
		
		func(a,target,startindex+1,ans+a[startindex]+" ",sum+a[startindex]);
		func(a,target,startindex+1,ans,sum);
	}

	public static void main(String[] args) 
	{
		
		int a[]= {10,20,30,40};
    int targetSum=60;
		func(a,targetSum,0,"",0);

	}

}
