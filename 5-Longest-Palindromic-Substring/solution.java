public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        char[] vals = s.toCharArray();
        int max = -1;
        int start = 0;
        int end = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j - i < 2) {
                    isPal[i][j] = vals[i] == vals[j];
                } else {
                    isPal[i][j] = isPal[i + 1][j - 1] && vals[i] == vals[j];
                }
                if (isPal[i][j] && j - i > max) {
                    start = i;
                    end = j;
                    max = j - i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}