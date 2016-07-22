public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sl = s.length();
        int pl = p.length();
        char[] sVal = s.toCharArray();
        char[] pVal = p.toCharArray();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;
        int starCount = 0;
        for (int i = 1; i <= pl; i++) {
            if (pVal[i - 1] == '*') {
                dp[0][i] = dp[0][i - 1];
                starCount++;
            }
        }
        if (sl + starCount < pl) {
            return false;
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (pVal[j - 1] == '?' || pVal[j - 1] == sVal[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pVal[j - 1] == '*'){
                    for (int k = 0; k <= i; k++) {
                        if (dp[k][j - 1]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[sl][pl];
    }
}