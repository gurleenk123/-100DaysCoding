//Fuction to print matrix,add two matrixs,check matrix is identity matrix
public class PrintingMatrix 
{
	public static void traverse(int a[][])
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] add(int a[][],int b[][])
	{
		int ans[][]=new int[a.length][b.length];
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				ans[i][j]=a[i][j]+b[i][j];
			}
		}
		return ans;
	}

	public static boolean checkIdentityMatrix(int a[][])
	{
		
		int rows=a.length;
		int cols=a[0].length;
		//as identity matrix should be square matrix
		if(rows!=cols)
			return false;
		else
		{
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					if(i==j && a[i][j]!=1)
						return false;
					else if(i!=j && a[i][j]!=0)
						return false;
					
				}
			}
			return true;
		}
		
	}
	public static void main(String[] args) 
	{
		int a[][]= {{1,2,3},{4,5,6},{7,8,9}};
		int b[][]= {{1,0,0},{0,1,0},{0,0,1}};
		
		traverse(add(a,b));
		
		System.out.println(checkIdentityMatrix(b));

	}

}
