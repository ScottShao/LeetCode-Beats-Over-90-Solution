public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int minDis = Integer.MAX_VALUE;
        boolean isSame = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (isSame && words[i].equals(word1)) {
                if (i1 != -1) {
                    minDis = Math.min(i - i1, minDis);
                } 
                i1 = i;
            } else if (words[i].equals(word1)) {
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