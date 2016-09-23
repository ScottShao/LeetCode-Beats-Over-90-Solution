public class Solution {
    public String reverseWords(String s) {
        if (s == null) return s;
        int len = s.length();
        if(len == 0) return s;
        char[] vals = s.toCharArray();
        reverse(vals, 0, len - 1);
        int idx = 0;
        for (int i = 0; i < len; ) {
            if (vals[i] != ' ') {
                int j = i + 1;
                while (j < len && vals[j] != ' ') j++;
                reverse(vals, i, j - 1);
                for (int k = i; k < j; k++) {
                    vals[idx++] = vals[k];
                }
                if (idx < len) vals[idx++] = ' ';
                i = j + 1;
            } else {
                i++;
            }
        }
        return idx == 0 ? "" : vals[idx - 1] == ' ' ? new String(vals, 0, idx - 1) : new String(vals, 0, idx);
    }
    
    private void reverse(char[] vals, int low, int high) {
        while (low < high) {
            char temp = vals[low];
            vals[low] = vals[high];
            vals[high] = temp;
            low++;
            high--;
        }
    }
}