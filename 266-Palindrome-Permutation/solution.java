public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return false;
        int len = s.length();
        if (len == 0) return true;
        int R = 256;
        char[] vals = s.toCharArray();
        boolean[] map = new boolean[R];
        for (char ch : vals) {
            map[ch] = !map[ch];
        }
        int count = 0;
        for (boolean b : map) {
            if (b) count++;
            if (count > 1) return false;
        }
        return true;
    }
}