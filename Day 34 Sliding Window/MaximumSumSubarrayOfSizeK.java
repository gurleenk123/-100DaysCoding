//Given an array of integers and a number k, find the maximum sum of a subarray of size k. 

// Examples: 

// Input  : arr[] = {100, 200, 300, 400}
//          k = 2
// Output : 700

// Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
//          k = 4 
// Output : 39

public class MaximumSumSubarrayOfSizeK 
{
	public static int func(int a[],int k)
	{
		int n=a.length;
		if(n<k)
			return -1;
		int sum=0;
		for(int i=0;i<k;i++)
		{
			sum+=a[i];
		}
		int currentSum=sum;
		for(int i=k;i<n;i++)
		{
			currentSum+=a[i] - a[i-k];
			sum=Math.max(currentSum, sum);
			
		}
		
		return sum;
		
	}

	//O(n)
	
	public static void main(String[] args) 
	{
		
		int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        
        System.out.println(func(arr, k));

	}

}

