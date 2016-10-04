public class Solution {
    public int maxProduct(String[] words) {
        if (words == null) return 0;
        int len = words.length;
        if (len == 0) return 0;
        int[] bits = stringToInt(words);
        int max = 0;
        for (int i = len - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
    
    private int[] stringToInt(String[] words) {
        int len = words.length;
        int[] bits = new int[len];
        for (int i = 0; i < len; i++) {
            char[] vals = words[i].toCharArray();
            for (int j = 0; j < vals.length; j++) {
                int idx = vals[j] - 'a' + 1;
                bits[i] = bits[i] | (1 << idx);
            }
        }
        return bits;
    }
}