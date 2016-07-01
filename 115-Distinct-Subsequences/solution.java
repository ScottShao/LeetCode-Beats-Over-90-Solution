public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return 0;
        int[] dp = new int[n + 1];
        char[] sVals = s.toCharArray();
        char[] tVals = t.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            int min = Math.min(i, n);
            for (int j = min; j >= 1; j--) {
                dp[j] += ((sVals[i - 1] == tVals[j - 1]) ? dp[j - 1] : 0);
            }
        }
        return dp[n];
        
    }
}