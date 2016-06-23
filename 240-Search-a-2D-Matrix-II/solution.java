public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
       
        return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    private boolean searchMatrix(int[][] matrix, int target, int rowIdx, int colIdx, int rows, int cols) {
        
        if (rowIdx > rows || colIdx > cols || matrix[rowIdx][colIdx] > target) {
            return false;
        } else if (matrix[rowIdx][colIdx] == target) {
            return true;
        }
        int prevRow = rowIdx;
        int prevCol = colIdx;
        int midRow = rowIdx;
        int midCol = colIdx;
        int rb = rows;
        int cb = cols;
        while (rowIdx < rows && colIdx < cols) {
            midRow = rowIdx + ((rows - rowIdx + 1) >>> 1);
            midCol = colIdx + ((cols - colIdx + 1) >>> 1);
            if (matrix[midRow][midCol] < target) {
                rowIdx = midRow;
                colIdx = midCol;
            } else if(matrix[midRow][midCol] > target) {
                rows = midRow - 1;
                cols = midCol - 1;
            } else{
                return true;
            }
        }
        
        return searchMatrix(matrix, target, prevRow, colIdx + 1, rowIdx + 1 > rb?rb:rowIdx+1, cb) || searchMatrix(matrix, target, rowIdx + 1, prevCol, rb, colIdx + 1 > cb?cb:colIdx+1);
        
    } 
}