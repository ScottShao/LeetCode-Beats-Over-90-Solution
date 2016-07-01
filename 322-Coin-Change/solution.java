public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                int idx = i - c;
                if (idx >= 0 && dp[idx] != -1) {
                    dp[i] = Math.min(dp[i], dp[idx] + 1);
                }
            }
            dp[i] = dp[i] == Integer.MAX_VALUE ? -1 : dp[i];
        }
        return dp[amount];
    }
}