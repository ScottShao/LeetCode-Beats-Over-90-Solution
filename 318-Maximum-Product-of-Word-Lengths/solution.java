public class Solution {
    private int len;
    public int maxProduct(String[] words) {
        if (words == null) return 0;
        len = words.length;
        if (len == 0) return 0;
        words = bucketSort(words);
        int[] bits = stringToInt(words);
        int max = 0;
        for (int i = len - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                    break;
                }
            }
        }
        return max;
    }
    
    private int[] stringToInt(String[] words) {
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
    
    private String[] bucketSort(String[] words) {
        int max = 0;
        for (String w : words) {
            max = Math.max(w.length(), max);
        }
        int[] count = new int[max + 1];
        for (String w : words) {
            count[w.length()]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        String[] re = new String[len];
        for (String w : words) {
            int len = w.length();
            count[len]--;
            re[count[len]] = w;
        }
        return re;
    }
}