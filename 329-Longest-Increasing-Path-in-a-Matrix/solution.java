public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mem = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, mem, matrix, Integer.MAX_VALUE));
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, int[][] mem, int[][] matrix, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= prev) {
            return 0;
        }
        if (mem[i][j] != 0) return mem[i][j];
        int crt = 0;
        int val = matrix[i][j];
        crt = Math.max(crt, dfs(i - 1, j, mem, matrix, val));
        crt = Math.max(crt, dfs(i + 1, j, mem, matrix, val));
        crt = Math.max(crt, dfs(i, j - 1, mem, matrix, val));
        crt = Math.max(crt, dfs(i, j + 1, mem, matrix, val));
        mem[i][j] = crt + 1;
        return mem[i][j];
    }
}