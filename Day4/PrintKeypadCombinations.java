//Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
//Note : The order of strings are not important. Just print different strings in new lines.

public class PrintKeypadCombinations 
{

	public static String codes[]={"","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	public static void PrintCombination(String number,String ans)
	{
		if(number.length()==0)
		{
			System.out.println(ans);
			return;
		}
		char firstChar=number.charAt(0);
		String options=codes[firstChar-'0'];
		for(int i=0;i<options.length();i++)
		{
			char ch=options.charAt(i);
			PrintCombination(number.substring(1),ans+ch);
			
		}
	}
	
	public static void main(String[] args) 
	{
		PrintCombination("23","");
		

	}

}
