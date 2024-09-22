class StockSpanner {
    private ArrayList<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        // Add the current price to the list of prices
        prices.add(price);
        int span = 1;
        int index = prices.size() - 2;  // Start from the previous day's price
        
        // While the previous day's price is less than or equal to today's price, keep going back
        while (index >= 0 && prices.get(index) <= price) {
            span++;
            index--;  // Move to the previous day
        }
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */