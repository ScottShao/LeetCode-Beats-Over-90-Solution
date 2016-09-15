public class Solution {
    private static final int D = 2;
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        LinkedHashMap<Character, Integer> ch2Idx = new LinkedHashMap<>((int)((D + 1) / 0.75) + 1, 0.75f, true);
        char[] vals = s.toCharArray();
        int maxLen = 0, len = vals.length, start = 0;
        for (int i = 0; i < len; i++) {
            ch2Idx.put(vals[i], i);
            if (ch2Idx.size() > D) {
                Map.Entry<Character, Integer> mapEntry = ch2Idx.entrySet().iterator().next();
                maxLen = Math.max(maxLen, i - start);
                start = mapEntry.getValue() + 1;
                ch2Idx.remove(mapEntry.getKey());
            }
        }
        return Math.max(len - start, maxLen);
    }
}