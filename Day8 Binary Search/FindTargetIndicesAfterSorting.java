// Leetcode Q 2089. Find Target Indices After Sorting Array
//Example 1:

// Input: nums = [1,2,5,2,3], target = 2
// Output: [1,2]
// Explanation: After sorting, nums is [1,2,2,3,5].
// The indices where nums[i] == 2 are 1 and 2.

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int firstOccurence=firstOcc(nums,target);
        int lastOccurence=LastOcc(nums,target);
        List<Integer> result = new ArrayList<>();
        if(firstOccurence == -1)
            return result;
        else
        {
            for(int i = firstOccurence; i<= lastOccurence; i++)
            {
                result.add(i);
            }
        }
        return result;
    }
    public static int firstOcc(int a[],int target)
	{
		int si=0;
		int ei=a.length-1;
		int mid;
		int ans=-1;
		while(si<=ei)
		{
			mid=si+(ei-si)/2;
			//agar mid me hi target hai toh left side check krege k or elements
			//hai and first kon sa
			if(target==a[mid])
			{
				ans=mid;
				ei=mid-1;
			}
			else if(a[mid]<target)
			{
				si=mid+1;
			}
			else
			{
				ei=mid-1;
			}
			
		}
		return ans;
	}
	public static int LastOcc(int arr[],int x)
	{
		int low = 0, high = arr.length - 1, 
			      res = -1;
			  while (low <= high) 
			  {
			   
			    int mid = (low + high) / 2;
			    if (arr[mid] > x)
			      high = mid - 1;
			    else if (arr[mid] < x)
			      low = mid + 1;

			    else 
			    {
			      res = mid;
			      low = mid + 1;
			    }
			  }
			  return res;
	}
}
