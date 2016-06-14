public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chs = s.toCharArray();
        int n = chs.length - 1;
        for (int j = (n - 1) >>> 1; j >= 0; j--) {
            int k = n - j;
            char cj = chs[j];
            char ck = chs[k];
            chs[j] = ck;
            chs[k] = cj;
        }
        return new String(chs);
    }
}