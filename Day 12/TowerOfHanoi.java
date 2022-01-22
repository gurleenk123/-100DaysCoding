public class TowerOfHanoi 
{
	
	public static void toh(int n,char src,char dest,char helper)
	{
		if(n==0)
			return ;
		
		
		toh(n-1,src,helper,dest);
		System.out.println(n+ " move from "+ src + " to "+ dest);
		toh(n-1,helper,dest,src);
	}

	public static void main(String[] args) 
	{
		toh(3,'A','B','C');
		

	}

}
