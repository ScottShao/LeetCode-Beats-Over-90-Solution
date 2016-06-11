public class Solution {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int val = 0;
        for (int i = 0; i < chs.length; i++) {
            val = 26 * val + chs[i] - '@';
        }
        return val;
    }
}