class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int mini=prices[0];
        for(int i=0;i<prices.length;i++){
            int cost= prices[i]-mini;
            mini=Math.min(mini,prices[i]);
            profit=Math.max(profit,cost);
        }
        return profit;
    }
}
