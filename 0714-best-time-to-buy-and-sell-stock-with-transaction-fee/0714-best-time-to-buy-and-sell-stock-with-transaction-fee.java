class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0]; // Initially bought
        int cash = 0;          // Initially no profit

        for (int i = 1; i < n; i++) {
           hold = Math.max(hold, cash - prices[i]);      // Buy (or keep holding)
           cash = Math.max(cash, hold + prices[i] - fee); // Sell (or keep resting)

        }

        return cash;
    }
}
