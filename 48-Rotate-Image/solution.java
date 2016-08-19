public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            n--;
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j + i][i];
                matrix[n - j + i][i] = matrix[n][n - j + i];
                matrix[n][n - j + i] = matrix[j][n];
                matrix[j][n] = temp;
            }
        }
    }
}