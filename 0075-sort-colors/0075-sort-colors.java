class Solution {
    public void sortColors(int[] nums) {
      //  Arrays.sort(nums);
      int low =0, mid=0, high=nums.length-1;
      while(mid<=high){
        if(nums[mid] == 0){
            int temp = nums[mid];
            nums[mid] = nums[low];
            nums[low]= temp;
            mid++;
            low++;
        }else if(nums[mid] == 1) mid++;
        else{
            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;
            high--;
        }
        }
    }
}