public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] vals = s.toCharArray();
        int last = vals.length - 1;
        while (last >= 0 && vals[last] == ' ') last--;
        for (int i = last; i >= 0; i--) {
            if (vals[i] == ' ') {
                return last - i;
            }
        }
        return last + 1;
    }
}