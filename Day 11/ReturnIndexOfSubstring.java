//Implement strStr().

//Return the index of the first occurrence of substring in string, or -1 if substring is not part of string.
//Example 1:

// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1

public class ReturnIndexOfSubstring {
	
	public static int strStr(String s1, String s2) 
    {
        if(s2.length()==0 || s1.equals(s2))
            return 0;
        int i=0;
        int j=s2.length();
        while(j <=s1.length())
        {
        	if(s1.substring(i, j).equals(s2))
        		return i;
        	i++;
        	j++;
        }
        return -1;
        
        
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("hello","ll"));

	}

}
