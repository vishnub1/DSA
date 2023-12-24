class Solution {
    public int maxProfit(int[] prices) {
        int minSofar = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - minSofar;
            profit = Math.max(currProfit, profit);
            
            minSofar = Math.min(minSofar, prices[i]);  // updating minimum so far
        }

        return profit;
    }
}