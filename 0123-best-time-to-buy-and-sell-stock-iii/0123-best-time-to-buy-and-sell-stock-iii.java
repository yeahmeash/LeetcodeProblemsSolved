class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // 1st pass: left to right (max profit up to day i)
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // 2nd pass: right to left (max profit from day i to end)
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Combine both parts
        int maxTotal = 0;
        for (int i = 0; i < n; i++) {
            maxTotal = Math.max(maxTotal, leftProfit[i] + rightProfit[i]);
        }

        return maxTotal;
    }
}

