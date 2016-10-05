public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mem = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, mem, matrix));
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, int[][] mem, int[][] matrix) {
        if (mem[i][j] != 0) return mem[i][j];
        int crt = 0;
        int val = matrix[i][j];
        if (i > 0 && matrix[i - 1][j] > val) crt = Math.max(crt, dfs(i - 1, j, mem, matrix));
        if (i < matrix.length - 1 && matrix[i + 1][j] > val) crt = Math.max(crt, dfs(i + 1, j, mem, matrix));
        if (j > 0 && matrix[i][j - 1] > val) crt = Math.max(crt, dfs(i, j - 1, mem, matrix));
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > val) crt = Math.max(crt, dfs(i, j + 1, mem, matrix));
        mem[i][j] = crt + 1;
        return mem[i][j];
    }
}