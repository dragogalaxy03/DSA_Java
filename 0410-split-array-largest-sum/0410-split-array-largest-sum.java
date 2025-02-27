class Solution {
    public int splitedLrgNum(int[] nums, int mid){
        int num = 1;
        int numSum =0;
        for(int i=0; i<nums.length; i++){
            if(numSum + nums[i]<=mid){
                numSum += nums[i];
            }else{
                num++;
                numSum = nums[i];
            }
        }
        return num;
    }
    public int splitArray(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int sum =0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum = sum + nums[i];
            if(maxi < nums[i]) 
                maxi = nums[i];
        }
        int low = maxi;
        int high = sum;
        while(low<=high){
            int mid = low + (high-low)/2;
            int lrgNum = splitedLrgNum(nums, mid);
            if(lrgNum>k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}