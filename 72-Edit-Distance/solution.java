public class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = w1.length;
        int n = w2.length;
        int[] dis = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dis[j] = j;
        }
        int prev = 0;
        for (int i = 0; i < m; i++) {
            dis[0] = i + 1;
            prev = i;
            for (int j = 0; j < n; j++) {
                int temp = dis[j + 1];
                if (w1[i] == w2[j]) {
                    dis[j + 1] = Math.min(prev, Math.min(dis[j], dis[j + 1]) + 1);
                } else {
                    dis[j + 1] = Math.min(prev, Math.min(dis[j], dis[j + 1])) + 1;
                }
                prev = temp;
            }
        }
        return dis[n];
    }
}