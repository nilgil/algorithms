class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int daily = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            daily = prices[i] - min;
            if (profit < daily) {
                profit = daily;
            }
        }
        return profit;
    }
}