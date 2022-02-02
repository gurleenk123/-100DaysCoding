//Leetcode 494. Target Sum
//You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

class Solution {
    public int findTargetSumWays(int[] nums, int target) 
    {
        
        
       int TS=0;
for(int a: nums)TS+=a;
target=Math.abs(target);
int S=(TS+target);
if(S%2!=0)return 0;
S/=2;

int n=nums.length;int sum=S;
int[][] t=new int[n+1][sum+1];

for(int i=0;i<n+1;i++)
{
    for(int j=0;j<sum+1;j++)
    {
        if(i == 0 && j == 0)
            t[i][j] = 1;
        else if(i == 0)
            t[i][j] = 0;
        else if(nums[i-1]<=j)
            t[i][j]=t[i-1][j-nums[i-1]]+t[i-1][j];
        else 
            t[i][j]=t[i-1][j];
    }
}
return t[n][sum];
    }
    
	
	
}
