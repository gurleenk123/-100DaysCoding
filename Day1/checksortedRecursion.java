//Program to check if an array is sorted or not (Recursively)
public class checksortedRecursion 
{

	static boolean func(int a[],int index)
	{
		//if whole array is traversed
		if(index >= a.length)
			return true;
		if(a[index] < a[index-1])
			return false;
		
		return func(a,index+1);
	
	}
	
	public static void main(String[] args) 
	{
		int a[]= {1,2,10};
		System.out.println(func(a,1));

	}

}
