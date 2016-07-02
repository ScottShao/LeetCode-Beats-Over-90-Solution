public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j - 1];
            }
            dp[0] = dp[1];
        }
        return dp[n];
    }
}