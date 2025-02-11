class Solution {
    public int daysReq(int[] weights, int cap){
        int day =1;
        int load = 0;
        for(int i=0; i<weights.length; i++){
            if(load+weights[i]>cap){
              day = day+1;
              load = weights[i];  
            }else{
                load += weights[i];
            }
        }
        return day;
    }

    public int sumoFWeights(int[] weights){
        int sum = 0;
        for(int i =0; i<weights.length;i++){
            sum += weights[i];
        }
        return sum;
    }

    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<weights.length; i++){
            maxi = Math.max(maxi, weights[i]);
        }
        int low = maxi;
        int high = sumoFWeights(weights);
        while(low<=high){
            int mid = low+(high-low)/2;
            int noOfDays = daysReq(weights, mid);
            if(noOfDays <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;

        
    }
}