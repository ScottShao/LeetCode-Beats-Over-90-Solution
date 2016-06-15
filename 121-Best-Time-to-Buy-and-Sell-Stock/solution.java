public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int min  = prices[0];
        int max = prices[0];
        int maxProfit = 0;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > max) {
                profit = prices[i] - min;
                max = prices[i];
            } else if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return Math.max(maxProfit, profit);
    }
}