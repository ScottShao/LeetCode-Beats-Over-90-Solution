public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] vals = s.toCharArray();
        int[] count = new int[256];
        int maxLen = 0;
        int low = 0;
        int high = 0;
        for (; high < n; high++) {
            if (count[vals[high]] == 0 || count[vals[high]] < low) {
                count[vals[high]] = high + 1;
            } else {
                maxLen = Math.max(maxLen, high - low);
                low = count[vals[high]];
                count[vals[high]] = high + 1;
            }
        }
        return Math.max(maxLen, high - low);
    }
}