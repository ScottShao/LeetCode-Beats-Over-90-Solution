public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = matrix[mid / m][mid % m];
            if (val > target) {
                high = mid - 1;
            } else if (val < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}