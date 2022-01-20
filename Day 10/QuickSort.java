public class QuickSort 
{
	public static int partition(int a[],int low,int high)
	{
		int pivot=a[high];
		int i=low-1;
		for(int j=low;j<high;j++)
		{
			if(a[j]<pivot)
			{
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		//swap a[i+1} and pivot
		int t=a[i+1];
		a[i+1]=a[high];
		a[high]=t;
		
		return i+1;
		
	}
	public static void sort(int a[],int low,int high)
	{
		if(low<high)
		{
			int mid=partition(a,low,high);
			sort(a,low,mid-1);
			sort(a,mid+1,high);
		}
	}
	static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
//Best Time Complexity : O(nlogn)
//Average Time Complexity : O(nlogn)
//Worst Time Complexity : O(n^2)
	
	
	public static void main(String[] args) 
	{
		int a[]= {12,45,10,13,4,9};
		System.out.println("before sorting");
		printArray(a,a.length);
		System.out.println("after sorting:");
		sort(a,0,a.length-1);
		printArray(a,a.length);
		
		

	}

}
