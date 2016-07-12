public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] vals = s.toCharArray();
        int[] count = new int[256];
        Arrays.fill(count, -1);
        int maxLen = 0;
        int low = 0;
        int high = 0;
        for (; high < n; high++) {
            if (count[vals[high]] == -1 || count[vals[high]] < low) {
                count[vals[high]] = high;
            } else {
                maxLen = Math.max(maxLen, high - low);
                low = count[vals[high]] + 1;
                count[vals[high]] = high;
            }
        }
        return Math.max(maxLen, high - low);
    }
}