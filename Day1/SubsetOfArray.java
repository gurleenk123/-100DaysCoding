//Given an integer array nums of unique elements, return all possible subsets (the power set).
public class SubsetOfArray 
{
	
	public static void printSubsets(int a[],int si,int output[])
	{
		if(si==a.length)
		{
			for(int i :output)
			{
				System.out.print(i+" ");
			}
			System.out.println( );
			return;
		}
		int newans[]=new int[output.length+1];
		int i=0;
		for( ;i<output.length;i++)
		{
			newans[i]=output[i];
		}
		newans[i]=a[si];
		printSubsets(a,si+1,output);
		printSubsets(a,si+1,newans);
	}

	public static void main(String[] args) 
	{
		int a[]= {12,20,21};
		int output[]=new int[0];
		printSubsets(a,0,output);

	}

}
