import java.util.HashMap;

public class CheckTwoStringsAreAnagram 
{
	public static boolean func(String s1,String s2)
	{
		HashMap<Character,Integer> map1=new HashMap<>();
		HashMap<Character,Integer> map2=new HashMap<>();
		if(s1.length()!=s2.length())
			return false;
		
		for(int i=0;i<s1.length();i++)
		{
			if(map1.containsKey(s1.charAt(i)))
			{
				map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
			}
			else
			{
				map1.put(s1.charAt(i), 1);
			}
		}
		

		for(int i=0;i<s2.length();i++)
		{
			if(map2.containsKey(s2.charAt(i)))
			{
				map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
			}
			else
			{
				map2.put(s2.charAt(i), 1);
			}
		}
		if(map1.equals(map2))
			return true;
		else
			return false;
			
		
		
	}

	public static void main(String[] args) 
	{
		System.out.println(func("abcd","abvc"));
		

	}

}
