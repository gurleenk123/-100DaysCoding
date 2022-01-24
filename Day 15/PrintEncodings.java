//Given the numeric string str, where 1 represents ‘a’, 2 represents ‘b’, …, 26 represents ‘z’, the task is to print all possible alphabetical strings that can be obtained from str.
public class PrintEncodings 
{
	

	public static void main(String[] args) 
	{
		func("123", "");

	}

	private static void func(String s, String ans)
	{
		
		if(s.length()==0)
		{
			System.out.println(ans);
			return;
		}
		else if(s.length()==1)
		{
			char ch=s.charAt(0);
			if(ch==0)
			{
				
				return;
			}
			else
			{
				char charValue= (char) (ch - '0');
				char code=(char)('a' + charValue - 1);
				System.out.println(ans+code);
			
			}
			
		}
		else
		{
			char ch=s.charAt(0);
			if(ch==0)
			{
				
				return;
			}
			else
			{
				char charValue= (char) (ch - '0');
				char code=(char)('a' + charValue - 1);
				func(s.substring(1),ans+code);
			
			}
			
			String ch12=s.substring(0,2);
			String reststring=s.substring(2);
			//convert ch12 into numerical value
			int ch12v=Integer.parseInt(ch12);
			if(ch12v<=26)
			{
				char code=(char)('a' + ch12v - 1);
				
				func(reststring,ans+code);
			}
			
			
		}
		
	}

}
