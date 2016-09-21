public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return false;
        int len = s.length();
        if (len == 0) return true;
        int R = 256;
        char[] vals = s.toCharArray();
        boolean[] map = new boolean[R];
        int min = 0, max = R - 1;
        for (char ch : vals) {
            map[ch] = !map[ch];
            min = Math.min(ch, min);
            max = Math.max(ch, max);
        }
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (map[i]) count++;
            if (count > 1) return false;
        }
        return true;
    }
}