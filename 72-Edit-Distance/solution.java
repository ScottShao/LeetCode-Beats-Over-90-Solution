public class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = w1.length;
        int n = w2.length;
        int[][] dis = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dis[0][j] = j;
        }
        for (int i = 0; i < m; i++) {
            dis[i + 1][0] = i + 1;
            for (int j = 0; j < n; j++) {
                if (w1[i] == w2[j]) {
                    dis[i + 1][j + 1] = Math.min(dis[i][j], Math.min(dis[i + 1][j], dis[i][j + 1]) + 1);
                } else {
                    dis[i + 1][j + 1] = Math.min(dis[i][j], Math.min(dis[i + 1][j], dis[i][j + 1])) + 1;
                }
            }
        }
        return dis[m][n];
    }
}