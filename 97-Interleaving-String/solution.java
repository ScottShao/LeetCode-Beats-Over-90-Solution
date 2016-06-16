public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[] dp = new boolean[l1 + 1];
        char[] v1 = s1.toCharArray();
        char[] v2 = s2.toCharArray();
        char[] v3 = s3.toCharArray();
        dp[0] = true;
        for (int i = 0; i < l1; i++) {
            dp[i + 1] = dp[i] && v1[i] == v3[i];
        }
        for (int i = 0; i < l2; i++) {
            dp[0] = dp[0] == true && v2[i] == v3[i];
            for (int j = 0; j < l1; j++) {
                int index = i + j + 1;
                if (v1[j] != v3[index] && v2[i] != v3[index]) {
                    dp[j + 1] = false;
                } else {
                    if (v1[j] == v3[index]) {
                        dp[j + 1] = dp[j + 1] || dp[j];
                    } 
                }
            }
        }
        return dp[l1];
    }
}