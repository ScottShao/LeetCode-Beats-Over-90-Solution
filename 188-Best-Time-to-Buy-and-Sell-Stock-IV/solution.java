public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        int n = prices.length;
        if (k >= n / 2) return quickSolve(prices);
        
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tempMax + prices[j]);
                tempMax = Math.max(tempMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
    
     private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}