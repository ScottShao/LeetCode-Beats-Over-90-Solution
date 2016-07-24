public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int M = matrix.length;
        if (M == 0) return 0;
        int N = matrix[0].length;
    
        int[] H = new int[N];   // histogram
        int[] L = new int[N];   // left index (where '1' starts)
        int[] R = new int[N];   // right index (where '1' ends + 1)
        Arrays.fill(R, N);
    
        int maxRect = 0;
        for (int i = 0; i < M; i++) {
            int left = 0, right = N;    // left and right indices of '1's in current row
    
            // calculate L[] in row i
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '1') {                    
                    H[j]++;
                    L[j] = Math.max(L[j], left); // compare L[j] with previous row, take the rightmost 
                } else {
                    H[j] = 0;
                    left = j + 1;
                    // edge case: when '0' appears, make L[j] = left and R[j] = right in next row
                    L[j] = 0;
                    R[j] = N;
                }
            }
    
            // calculate R[] and area in row i
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    R[j] = Math.min(R[j], right);   // compare R[j] with previous row, take the leftmost
                    maxRect = Math.max(maxRect, H[j] * (R[j] - L[j]));
                } else {
                    right = j;
                }                
            }
        }
    
        return maxRect;
    }
}