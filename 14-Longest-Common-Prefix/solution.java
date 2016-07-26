public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[] vals = strs[0].toCharArray();
        int end = vals.length;
        for (int i = 1; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            int j = 0;
            for (; j < end && j < temp.length; j++) {
                if (temp[j] != vals[j]) {
                    break;
                }
            }
            end = j;
        }
        return new String(vals, 0, end);
    }
}