class Solution {
    public int maxElement(int[] piles){
        int maxi = Integer.MIN_VALUE;;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public int totalHours(int[] piles, int m){
        int totalH = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(m));
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high =  maxElement(piles);
        while(low<=high){
            int mid = low+(high-low)/2;
            int totalHr = totalHours(piles,mid);
            if(totalHr <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
        
    }
}