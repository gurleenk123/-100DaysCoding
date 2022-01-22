
public class MaximumOfArrayUsingRecursion 
{
	public static int maxx(int arr[],int index)
	{
		if(index==arr.length-1)
			return arr[index-1];
		int ms=maxx(arr,index+1);
		if(ms>arr[index])
			return ms;
		else
			return arr[index];
	}
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a[]= {12,23,11,3,20};
		System.out.println("max ele is :"+maxx(a,0));

	}

}
