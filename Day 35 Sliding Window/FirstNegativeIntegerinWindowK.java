//Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
//N = 5
// A[] = {-8, 2, 3, -6, 10}
// K = 2
// Output : 
// -8 0 -6 -6
// Explanation :
// First negative integer for each window of size k
// {-8, 2} = -8
// {2, 3} = 0 (does not contain a negative integer)
// {3, -6} = -6
// {-6, 10} = -6

import java.util.*;

public class FirstNegativeIntegerinWindowK 
{
	public static void bruteForce(int a[],int n,int k)
	{
		boolean flag;
		for(int i=0;i<(n-k+1);i++)
		{
			flag=false;
			for(int j=0;j<k;j++)
			{
				if(a[i+j] < 0)
				{
					System.out.print(a[i+j] +" ");
					flag=true;
					break;
				}
				
					
			}
			if (!flag)
	            System.out.print("0"+" ");
			
		}
	}
	public static int[] printFirst(int a[],int n,int k)
	{
		int i = 0 , j=0;
        Queue<Integer> q = new LinkedList<>();
        int result[]=new int[n-k+1];
        int idx = 0; 
        
        while(j< n)
        {
        	if(a[j] < 0)
        		q.add(a[j]);
        	
             if(j-i+1 == k)
             {
                

                if(q.size()==0)
                {
                   
                result[idx++] = 0;
                
                }
                else
                {
                    
                result[idx++] = q.peek(); 

                if(a[i] == q.peek())
                {
                    
                q.poll();
                }
                
                
                }
            i++;

            }
            
            
            j++;
            
        }
        
        

        	
        
        
        return result;
	}
	

	public static void main(String[] args) 
	{
		int N = 5;
		int A[] = {-8, 2, 3, -6, 10};
		int K = 2;
		//bruteForce(A,N,K);
		
		int[] res=printFirst(A,N,K);
		for(int i=0;i<res.length;i++)
		{
			System.out.print(res[i] +" ");
		}
		

	}

}
