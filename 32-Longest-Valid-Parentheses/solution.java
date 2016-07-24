public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) return 0;
        int max = 0;
        int[] d = new int[n];
        d[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + 1 + d[i + 1];
                if (j < n && s.charAt(j) == ')') {
                    d[i] = d[i + 1] + 2;
                    if (j + 1 < n)
                        d[i] += d[j + 1];
                }
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }
}