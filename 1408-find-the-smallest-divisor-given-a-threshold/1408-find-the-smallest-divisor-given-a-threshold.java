class Solution {

    public int sumOfDiv(int[] nums, int div){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double)(nums[i])/ (double)(div));
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        int high = maxi;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(sumOfDiv(nums, mid) <= threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
        
    }
}