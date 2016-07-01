public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        char[] sVals = s.toCharArray();
        char[] tVals = t.toCharArray();
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= Math.min(i, n); j++) // skip the case of i < j
            // for (int j = Math.min(i, n); j >= 1; j--) // scan reversely also works
                dp[i][j] = dp[i - 1][j] + ((sVals[i - 1] == tVals[j - 1]) ? dp[i - 1][j - 1] : 0);
        return dp[m][n];
        
    }
}