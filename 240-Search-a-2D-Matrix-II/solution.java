public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    public boolean searchMatrix(int[][] matrix, int target, int i, int j, int n, int m) {
        if (i > n || j > m) return false;
        if (target > matrix[n][m]) return false;
        if (target < matrix[i][j]) return false;
        int low = 0;
        int high = Math.min(n - i, m - j);
        while (low < high) {
            int mid = low + ((high - low + 1) >>> 1);
            int iIdx = i + mid;
            int jIdx = j + mid;
            if (matrix[iIdx][jIdx] > target) {
                high = mid - 1;
            } else if (matrix[iIdx][jIdx] < target) {
                low = mid;
            } else {
                return true;
            }
        }
        return matrix[i + low][j + low] == target || searchMatrix(matrix, target, i, j + low + 1, i + low, m) || searchMatrix(matrix, target, i + low + 1, j, n, j + low);
    }
}