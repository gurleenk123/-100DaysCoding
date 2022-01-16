// Leetcode Q 744. Find Smallest Letter Greater Than Target
//Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.

public class NextGreaterAlphabet 
{
	
	public static char func(char letters[],char target)
	{
		int s=0;
	    int e=letters.length-1;
	    
	     if(target>=letters[e])
	     {
	        return letters[0];
	     }
	    while(s<=e)
	    {
	        int m = s+(e-s)/2;
	        if(target < letters[m]){
	            e = m-1;
	        }
	        else if(target>=letters[m]){
	            s = m+1;
	        }
	    }
	    return letters[s];
			
	}

	public static void main(String[] args) 
	{
		char letters[] = { 'c', 'r', 't' };
     
        char result = func(letters, 's');
 
       
        System.out.println(result);

	}

}
