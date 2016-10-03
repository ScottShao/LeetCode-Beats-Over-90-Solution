public class NumMatrix {
    private int BIT2D[][];
    private int matrix[][];
    
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        BIT2D = new int[matrix.length + 1][matrix[0].length + 1];
        this.matrix = matrix;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                init(i, j, matrix[i][j]);
            }
        }
    }
    
    public void init(int row, int col, int val) {
        for(int i = row + 1; i < BIT2D.length; i += i & (-i)) {         //also equals to i |= i + 1
            for(int j = col + 1; j < BIT2D[0].length; j += j & (-j)) {
                BIT2D[i][j] += val;
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        init(row, col, delta);
    }
    

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2 + 1, col2 + 1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1) + getSum(row1, col1); 
    }
    
    private int getSum(int row, int col) {
        int sum = 0;
        for(int i = row; i > 0; i -= i & (-i)) {
            for(int j = col; j > 0; j -= j & (-j)) {
                sum += BIT2D[i][j];
            }
        }
        return sum;
    }
    
    
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);