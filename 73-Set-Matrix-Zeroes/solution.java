public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean is1stRow = false;
        boolean is1stCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) is1stRow = true;
                    else matrix[0][j] = 0;
                    if (j == 0) is1stCol = true;
                    else matrix[i][0] = 0;
                    
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (is1stCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (is1stRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        
    }
}