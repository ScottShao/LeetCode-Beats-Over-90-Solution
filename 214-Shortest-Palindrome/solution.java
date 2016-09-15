public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        char[] vals = s.toCharArray();
        int len = vals.length;
        int j = len / 2;
        int i = (len - 1) / 2;
        String res = null;
        while (i >= 0) {
            res = checkPalindrome(vals, i, j);
            if (res != null) {
                return res;
            }
            if (i < j) j--;
            else i--;
        }
        return res;
    }
    
    private String checkPalindrome(char[] vals, int i, int j) {
        while (i >= 0) {
            if (vals[i] != vals[j]) {
                break;
            }
            i--;
            j++;
        }
        if (i >= 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int k = vals.length - 1; k >= j; k--) {
            sb.append(vals[k]);
        }
        sb.append(vals);
        return sb.toString();
    }
}