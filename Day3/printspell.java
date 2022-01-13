//Given a number N, the task is to convert every digit of the number into words.
public class printspell 
{
	
	public static void func(int n,String[] s)
	{
		if(n==0)
			return ;
		
		func(n/10,s);
		System.out.print(s[n%10]+" ");
		
	}

	public static void main(String[] args) 
	{
		String str[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		func(4312,str);
		
	}
	

}
