public class Solution {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int val = 0;
        for (char ch : chs) {
            val = 26 * val + ch - '@';
        }
        return val;
    }
}