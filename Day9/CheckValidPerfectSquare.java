//Given a positive integer num, write a function which returns True if num is a perfect square else False.
class Solution {
    public boolean isPerfectSquare(int num) 
    {
        if(num==1){
            return true;
        }
        int start = 0;
        int end = num/2;
        while(start<=end){
            long mid = start + (end - start) / 2;
            long sq = mid*mid;
            if(sq>num){
                end = (int)mid-1;
            }
            else if(sq<num){
                start=(int)mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
