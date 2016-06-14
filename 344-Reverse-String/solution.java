public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chs = s.toCharArray();
        int low = 0;
        int high = chs.length - 1;
        while (low < high) {
            chs[low] ^= chs[high];
            chs[high] ^= chs[low];
            chs[low] ^= chs[high];
            low++;
            high--;
        }
        return new String(chs);
    }
}