// Leetcode Q415  Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
public class AddTwoNumbersRepresentedByString 
{
	public static String func(String s1,String s2)
	{
		int i=s1.length()-1,j=s2.length()-1;
		int carry=0;
		int sum=0;
		String ans="";
		
		
		while(i>=0 || j>=0 || carry!=0)
		{
			int ivalue=i>=0 ? s1.charAt(i)-'0' : 0;
			int jvalue=j>=0 ? s2.charAt(j)-'0' : 0;
			
			i--;
			j--;
            sum=ivalue+jvalue+carry;
			
			ans=(sum%10)+ans;
			carry=sum/10;
		}
		return ans;
		
	}

	public static void main(String[] args)
	{
		System.out.println(func("99432","684"));
		

	}

}
