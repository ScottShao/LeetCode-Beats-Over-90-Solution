public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        char[] v1 = s1.toCharArray();
        char[] v2 = s2.toCharArray();
        char[] v3 = s3.toCharArray();
        for (int i = 0; i < l1; i++) {
            if (v1[i] == v3[i]) {
                dp[i + 1][0] = true;
            } else {
                break;
            }
        }
        
        for (int i = 0; i < l2; i++) {
            if (v2[i] == v3[i]) {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int index = i + j - 1;
                if (v1[i - 1] != v3[index] && v2[j - 1] != v3[index]) {
                    dp[i][j] = false;
                } else {
                    if (v1[i - 1] == v3[index]) {
                        dp[i][j] = dp[i- 1][j];
                    }
                    if (v2[j - 1] == v3[index]) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[l1][l2];
    }
}