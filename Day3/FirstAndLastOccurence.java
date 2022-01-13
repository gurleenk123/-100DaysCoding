//Find the first and Last Occurence index of number in an array
public class FirstAndLastOccurence 
{
	
	public static int firstOccurence(int a[],int index,int x)
	{
		if(index==a.length)
		{
			return -1;
			
		}
		if(a.length==1 && a[0]==x)
		{
			return 0;
		}
		if(a[index]==x)
			return index;
		return firstOccurence(a,index+1,x);
	}
	
	public static int LastOccurence(int a[],int index,int x)
	{
		if(index==a.length)
		{
			return -1;
			
		}
		int in=LastOccurence(a,index+1,x);
		if(in!=-1)
		{
			return in;
		}
		if(a[index]==x)
		{
			return index;
		}
		return -1;
		
	}

	public static void main(String[] args) 
	{
		int a[]= {12,2,4,2,13};
		System.out.println("First Occurence of 2 is:"+ firstOccurence(a,0,2));
		System.out.println("Last Occurence of 2 is:"+ LastOccurence(a,0,2));
		

	}

}
