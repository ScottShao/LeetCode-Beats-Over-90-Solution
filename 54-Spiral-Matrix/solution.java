public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return results;
        }
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++) {
                results.add(matrix[startRow][j]);
            }
            startRow++;
            
            for (int i = startRow; i <= endRow; i++) {
                results.add(matrix[i][endCol]);
            }
            endCol--;
            
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    results.add(matrix[endRow][j]);
                }
                endRow--;
            }
            
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    results.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return results;
    }
}