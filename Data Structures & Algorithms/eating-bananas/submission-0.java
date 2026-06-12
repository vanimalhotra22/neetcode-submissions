class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int low = 1;  // The minimum possible speed
        int high = 0; // The maximum possible speed (max number of bananas in a pile)
        
        // Find the maximum number of bananas in a pile to set the upper bound for k
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;  // Midpoint speed
            int totalHours = 0;
            
            // Calculate the total time to eat all the piles with the speed `mid`
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;  // Same as Math.ceil(pile / mid)
            }
            
            if (totalHours <= h) {
                high = mid;  // Try a slower speed
            } else {
                low = mid + 1;  // Try a faster speed
            }
        }
        
        return low; 
    }
}
