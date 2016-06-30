public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];//k == 0, dp[i] = 0
        int K = 2, tmpMax = 0;  
        for(int k =1; k<=K; k++) {
            tmpMax = dp[0] - prices[0];
            dp[0] = 0;
            for(int i = 1; i<prices.length; i++) {
                tmpMax = Math.max(tmpMax, dp[i] - prices[i]);
                dp[i] = Math.max(dp[i-1], prices[i]+tmpMax);
            }
        }
        return dp[prices.length -1];
    }
}