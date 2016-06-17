public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int c2 = dp[p2] * 2;
            int c3 = dp[p3] * 3;
            int c5 = dp[p5] * 5;
            dp[i] = Math.min(c2, Math.min(c3, c5));
            if (dp[i] == c2) p2++;
            if (dp[i] == c3) p3++;
            if (dp[i] == c5) p5++;
        }
        return dp[n - 1];
    }
}