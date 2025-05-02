class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i =0; i<n; i++){
            int temp = nums[i];
            int remain = target-temp;
            if(map.containsKey(remain)){
                return new int[]{map.get(remain), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};        
    }
}