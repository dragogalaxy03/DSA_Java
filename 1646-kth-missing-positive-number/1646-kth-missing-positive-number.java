class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low =0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k) low = mid+1;
            else high = mid-1;
        }
        return (low+k);
        //why low+k
        /*ans = ar[high]+more 
        ar[high]+k-missing   (more = k-missing) 
        ar[high] + k - (ar[high]- high-1)    (missing = arr[mid]-(mid+1))
        ar[high] + k - ar[high] + high + 1
        k + high + 1
        low + k  (high + 1 = low)*/
        
    }
}