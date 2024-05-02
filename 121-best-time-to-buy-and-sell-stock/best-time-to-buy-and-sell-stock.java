class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int minSofar = prices[0];
        int profit = 0;

        for(int i = 1; i < n; i++) {
            int currProfit = prices[i] - minSofar;
            profit = Math.max(currProfit, profit);
            
            minSofar = Math.min(minSofar, prices[i]); // updating min so far
        }

        return profit;
    }
}