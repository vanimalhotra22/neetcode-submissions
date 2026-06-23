class Solution {
    public int lastStoneWeightII(int[] stones) {
       int total = 0;

        for(int x : stones) {

            total += x;
        }

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int stone : stones) {

            for(int j = target; j >= stone; j--) {

                dp[j] = dp[j] || dp[j - stone];
            }
        }

        int s1 = 0;

        for(int j = target; j >= 0; j--) {

            if(dp[j]) {

                s1 = j;

                break;
            }
        }

        int s2 = total - s1;

        return Math.abs(s1 - s2); 
    }
}