public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int endRow = matrix.length - 1;
        if (endRow < 0) {
            return results;
        }
        int startRow = 0;
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
            
            for (int j = endCol; j >= startCol && startRow <= endRow; j--) {
                results.add(matrix[endRow][j]);
            }
            endRow--;
           
            
            for (int i = endRow; i >= startRow && startCol <= endCol; i--) {
                results.add(matrix[i][startCol]);
            }
            startCol++;
           
        }
        return results;
    }
}