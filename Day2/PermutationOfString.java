//Given a string str, the task is to print all the permutations of str. 

public class PermutationOfString 
{
	
	public static void permutation(String s,String ans)
	{
		if(s.length()==0)
		{
			System.out.println(ans);
			return;
		}
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			String left=s.substring(0,i);
			String right=s.substring(i+1);
			//rest of string
			String res=left+right;
			
			permutation(res,ans+ch);
		}
	}

	public static void main(String[] args) 
	{
		
		permutation("abc","");

	}

}
