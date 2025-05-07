class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int length = prices.length;

        for (int index = 0; index < length - 1; index++) {
            if (prices[index + 1] > prices[index]) {
                maxProfit = maxProfit + (prices[index + 1] - prices[index]);
            }
        }

        return maxProfit;
    }
}