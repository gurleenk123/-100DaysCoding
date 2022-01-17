//Leetcode Q4  Median of Two Sorted Arrays

public class MedianOfTwoSortedArrays 
{
	public static double findMedian(int[] nums1, int[] nums2) 
    {
        
		if(nums1.length > nums2.length){
	        return(findMedian(nums2, nums1));
	    }
	    int n1=nums1.length;
	    int n2=nums2.length;
	    int lo=0,hi=n1;
	    while(lo<=hi)
	    {

	        int cut1=lo+(hi-lo)/2;

	        int cut2=((n1+n2)/2)-cut1;

	        int l1= (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
	        int l2= (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
	        int r1= (cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
	        int r2= (cut2==n2)?Integer.MAX_VALUE:nums2[cut2];

	        if(l1>r2) hi=cut1-1;
	        else if(l2>r1) lo=cut1+1;
	        else
	        {

	            if((n1+n2)%2==0)
	                return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
	            else
	                return (double)(Math.min(r1,r2));
	        }

	    } 
	    return 0.0; 
        
    }

	public static void main(String[] args) {

		int a1[]= {1,3,6};
		int a2[]= {4,5};
		System.out.println(findMedian(a1,a2));
		

	}

}
