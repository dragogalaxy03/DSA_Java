class Solution {
    public static boolean possible(int[] bloomDay, int mid, int m, int k) {
        int cnt = 0;  // Count of consecutive blooming flowers
        int noOfB = 0; // Number of bouquets formed

        for (int i = 0; i < bloomDay.length; i++) {  
            if (bloomDay[i] <= mid) {  
                cnt++;  // Flower is bloomed, increase count
                if (cnt == k) {  
                    noOfB++; // A bouquet is formed
                    cnt = 0; // Reset counter
                }
            } else {
                cnt = 0;  // Reset count when flowers are not consecutive
            }
        }
        
        return noOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; // Size of the array
        if (val > n) return -1; // Impossible case

        // Find minimum and maximum bloom day
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        // Apply Binary Search
        int low = mini, high = maxi;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1; // Try for an earlier day
            } else {
                low = mid + 1; // Increase the bloom day
            }
        }
        return low;
    }
}
