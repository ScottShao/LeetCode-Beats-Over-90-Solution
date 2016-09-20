public class Solution {
    public String reverseVowels(String s) {
        if (s == null) return s;
        int len = s.length();
        char[] vals = s.toCharArray();
        int left = 0, right = len - 1;
        final String vowels = "aeiouAEIOU";
        while (left < right) {
            boolean needExchange = true;
            if (vowels.indexOf(vals[left]) < 0) {
                needExchange = false;
                left++;
            }
            if (vowels.indexOf(vals[right]) < 0) {
                needExchange = false;
                right--;
            }
            if (needExchange) {
                vals[left] ^= vals[right];
                vals[right] ^= vals[left];
                vals[left] ^= vals[right];
                left++;
                right--;
            }
        }
        return new String(vals);
    }
}