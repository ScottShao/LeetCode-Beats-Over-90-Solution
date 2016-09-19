public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i2 != -1) {
                    minDis = Math.min(i1 - i2, minDis);
                }
            } else if (words[i].equals(word2)) {
                i2 = i;
                if (i1 != -1) {
                    minDis = Math.min(i2 - i1, minDis);
                }
            }
        }
        return minDis;
    }
}