//Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. 
//Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum. 
import java.util.Arrays;

public class MinimumPageAllocation 
{
	public static int minPages(int books[],int students)
	{
		//if books are less then students we can'y divide them
		if (books.length < students)
            return -1;
     
        // Count total number of pages of books to take as end
		int sum=0;
        for (int i = 0; i < books.length; i++)
            sum += books[i];
        
		//finding max element in books array to take as start
		//also 0 can be taken
		int max= Arrays.stream(books).max().getAsInt();
		int si=max,ei=sum,res=-1;
		
		while(si<=ei)
		{
			int mid=si+(ei-si)/2;
			if(isValid(books,students,mid))
			{
				res=mid;
				ei=mid-1;
			}
			else
				si=mid+1;
			
		}
		return res;
		
	}
	public static boolean isValid(int a[],int k,int maxvalue)
	{
		int students=1,sum=0;
		for(int i=0;i<a.length;i++)
		{
			if(sum+a[i] > maxvalue)
			{
				students+=1;
				sum=a[i];
			}
			else
				sum+=a[i];
		}
		return (students<=k);
	}

	public static void main(String[] args) 
	{
		int books[]= {12, 34, 67, 90};
		System.out.println(minPages(books,2));

	}

}
//output is 113
