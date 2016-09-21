public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null) return 0;
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return 0;
        int[] dp= new int[k];
        int[] tmp = new int[k];
        for (int j =0; j < k; ++j) dp[j] = costs[0][j];
        for (int i = 1; i < n; ++i) {
            // Index of the minimum value in dp[].
            int p = dp[0] < dp[1] ? 0 : 1;
            // Index of the second minimum value in dp[].
            int q = dp[0] < dp[1] ? 1 : 0;
            for (int j = 2; j < k; j++) {
                if (dp[j] < dp[p]) {
                    q = p;
                    p = j;
                } else if (dp[j] < dp[q]) {
                    q = j;
                }
            }
            for (int j = 0; j < k; ++j) {
                tmp[j] = costs[i][j];
                if (j != p) {
                    tmp[j] += dp[p];
                } else {
                    tmp[j] += dp[q];
                }
            }
            for (int j =0; j < k; ++j) dp[j] = tmp[j];
        }
        int min = dp[0];
        for (int j = 0; j < k; ++j) {
                min = Math.min(min, dp[j]);
        }
        return min;
    }
}