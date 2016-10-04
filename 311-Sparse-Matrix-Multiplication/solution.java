public class Solution {
    public static int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) return null;
        int lenA = A.length;
        int lenA0 = A[0].length;
        int lenB = lenA0;
        int lenB0 = B[0].length;
        int[][] skipA = getSkips(A, true);
        int[][] skipB = getSkips(B, false);
        int[][] re = new int[lenA][lenB0];
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB0; j++) {
                int l = Math.max(skipA[i][0], skipB[0][j]);
                int val = 0;
                for (int m = l; m < lenB; m += l) {
                    val += A[i][m] * B[m][j];
                    l = Math.max(1, Math.max(skipA[i][m], skipB[m][j]));
                }
                re[i][j] = val;
            }
        }
        return re;
        
    }
    
    private static int[][] getSkips(int[][] A, boolean isRow) {
        int lenA = A.length;
        int lenA0 = A[0].length;
        int[][] skip = new int[lenA][lenA0];
        if (!isRow) {
            int temp = lenA;
            lenA = lenA0;
            lenA0 = temp;
        }
        for (int i = 0; i < lenA; i++) {
            int step = 0;
            int j = 0;
            while (j < lenA0) {
                int temp = j;
                while (j < lenA0 && (isRow ? A[i][j] : A[j][i]) == 0)  {
                    step++;
                    j++;
                    
                }
                if (isRow) skip[i][temp] = step;
                else skip[temp][i] = step;
                if (step == 0) j++;
                step = 0;
            }
        }
        return skip;
    }
}