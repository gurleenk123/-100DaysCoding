import java.util.Arrays;

public class BooleanParenthesization 
{
	

	public static void main(String[] args) 
	{
		String symbols = "TTFT";
        String operators = "|&^";
        StringBuilder S = new StringBuilder();
        int j = 0;
 
        for (int i = 0; i < symbols.length(); i++)
        {
            S.append(symbols.charAt(i));
            if (j < operators.length())
                S.append(operators.charAt(j++));
        }
 
        // We obtain the string  T|T&F^T
        int N = S.length();
 
        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and
        // (T|((T&F)^T))
        //System.out.println(countWays(S.toString(),N));
		//
        System.out.println(countWays(S.toString(),N-1));
		

	}

	public static int countWays(String s,int N) 
	{
		
		int dp[][][] = new int[N + 1][N + 1][2];
		 
        for (int row[][] : dp)
            for (int col[] : row)
                Arrays.fill(col, -1);
        return funcMemo(s, 0, N - 1, 1, dp);
	
	}
	public static int funcMemo(String str,int i,int j,int isTrue,int dp[][][])
	{
		if (i > j)
            return 0;
 
        if (i == j)
        {
            if (isTrue == 1)
            {
                return (str.charAt(i) == 'T') ? 1 : 0;
            }
            else
            {
                return (str.charAt(i) == 'F') ? 1 : 0;
            }
        }
 
        if (dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];
 
        int temp_ans = 0;
 
        int leftTrue, rightTrue, leftFalse, rightFalse;
 
        for (int k = i + 1; k <= j - 1; k = k + 2)
        {
 
            if (dp[i][k - 1][1] != -1)
                leftTrue = dp[i][k - 1][1];
            else
            {
                // Count number of True in left Partition
                leftTrue = funcMemo(str, i, k - 1,
                                             1, dp);
            }
            if (dp[i][k - 1][0] != -1)
                leftFalse = dp[i][k - 1][0];
            else
            {
               
                // Count number of False in left Partition
                leftFalse = funcMemo(str, i, k - 1,
                                              0, dp);
            }
            if (dp[k + 1][j][1] != -1)
                rightTrue = dp[k + 1][j][1];
            else
            {
               
                // Count number of True in right Partition
                rightTrue = funcMemo(str, k + 1, j,
                                              1, dp);
            }
            if (dp[k + 1][j][0] != -1)
                rightFalse = dp[k + 1][j][0];
            else
            {
               
                // Count number of False in right Partition
                rightFalse =funcMemo(str, k + 1,
                                               j, 0, dp);
            }
 
            // Evaluate AND operation
            if (str.charAt(k) == '&')
            {
                if (isTrue == 1)
                {
                    temp_ans
                        = temp_ans + leftTrue * rightTrue;
                }
                else
                {
                    temp_ans = temp_ans
                               + leftTrue * rightFalse
                               + leftFalse * rightTrue
                               + leftFalse * rightFalse;
                }
            }
            // Evaluate OR operation
            else if (str.charAt(k) == '|')
            {
                if (isTrue == 1)
                {
                    temp_ans = temp_ans
                               + leftTrue * rightTrue
                               + leftTrue * rightFalse
                               + leftFalse * rightTrue;
                }
                else
                {
                    temp_ans
                        = temp_ans + leftFalse * rightFalse;
                }
            }
           
            // Evaluate XOR operation
            else if (str.charAt(k) == '^')
            {
                if (isTrue == 1)
                {
                    temp_ans = temp_ans
                               + leftTrue * rightFalse
                               + leftFalse * rightTrue;
                }
                else
                {
                    temp_ans = temp_ans
                               + leftTrue * rightTrue
                               + leftFalse * rightFalse;
                }
            }
            dp[i][j][isTrue] = temp_ans;
        }
        return temp_ans;
		
	}

	private static int funcRecursive(String s, int i, int j, boolean isTrue) 
	{
		if(i>j)
			return 0;
		if(i==j)
		{
			if(isTrue==true)
				return (s.charAt(i) == 'T') ? 1 : 0;
			else
				return (s.charAt(i) == 'F') ? 1 : 0;	
		}
		int ans = 0;
		for(int k=i+1; k <= j-1 ;k=k+2)
		{
			int lt=funcRecursive(s,i,k-1,true);
			int lf=funcRecursive(s,i,k-1,false);
			int rt=funcRecursive(s,k+1,j,true);
			int rf=funcRecursive(s,k+1,j,false);
			
			if(s.charAt(k)=='&')
			{
				if(isTrue==true)
					ans = ans + lt + rt;
				else
					ans= ans + lf*rt + lf*rf + lt*rf;
					
			}
			else if(s.charAt(k)=='|')
			{
				if(isTrue==true)
					ans= ans + lt*rt + lt*rf + lf*rt ;
				else
					ans=ans + lf*rf;
			}
			else if(s.charAt(k)=='^')
			{
				if(isTrue==true)
					ans= ans + lf*rt + lt*rf;
				else
					ans= ans + lf*rf + lt*rt;
			}
			
			
		}
		return ans;
	}
	

}
