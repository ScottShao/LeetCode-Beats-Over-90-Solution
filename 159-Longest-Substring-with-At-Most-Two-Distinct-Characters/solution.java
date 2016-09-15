public class Solution {
    private static final int D = 2;
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] vals = s.toCharArray();
        int[] chIdx = new int[256];
        Arrays.fill(chIdx, -1);
        int start = 0;
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            int idx = chIdx[vals[i]];
            if (idx < start) count++;
            chIdx[vals[i]] = i;
            if (count > D) {
               maxLen = Math.max(maxLen, i - start);
               int newStart = i;
               for (int j = 0; j < 256; j++) {
                   if (chIdx[j] >= start) {
                       newStart = Math.min(newStart, chIdx[j]);
                   }
               }
               start = newStart + 1;
               count = D;
            }
        }
        return Math.max(vals.length - start, maxLen);
    }
}