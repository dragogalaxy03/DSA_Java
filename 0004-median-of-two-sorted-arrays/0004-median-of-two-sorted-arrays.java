class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int partition = (nums1.length + nums2.length + 1 )/2;
        int low = 0;
        int high = nums1.length;
        while(low<=high){
            int mid1 = low + (high-low)/2;
            int mid2 = partition - mid1;

            int l1 = mid1==0? Integer.MIN_VALUE:nums1[mid1-1];
            int r1 = mid1==nums1.length? Integer.MAX_VALUE:nums1[mid1];

            int l2 = mid2==0? Integer.MIN_VALUE:nums2[mid2-1];
            int r2 = mid2==nums2.length? Integer.MAX_VALUE:nums2[mid2];
            
            if(l1 <= r2 && l2 <= r1) {
                // we have solution 
                if((nums1.length+nums2.length)%2==0) {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0f;
                }
                return Math.max(l1,l2);
            } else if(l1>r2) {
                // we picked more elements from nums1; reduce high 
                high = mid1;
            } else if(l2>r1) {
                // we picked less elements from nums1; increase low 
                low = mid1+1;
            }
            
        }
        return -1;
    }
}