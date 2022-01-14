//Given a string S, remove all the consecutive duplicates.
public class RemoveDuplicatesFromString 
{
	
	public static String func(String s)
	{
		if(s.length()<=1)
		{
			
			return s;
		}
		if(s.charAt(0)==s.charAt(1))
		{
			return func(s.substring(1));
		}
		else
		{
			return s.charAt(0)+ func(s.substring(1));
		}
		
	}

	public static void main(String[] args) 
	{
		System.out.println(func("aabbeed"));

	}

}
