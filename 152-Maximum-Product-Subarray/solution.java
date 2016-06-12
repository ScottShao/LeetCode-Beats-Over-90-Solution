public class Solution {
    public int maxProduct(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
    
        int min = A[0];
        int max = A[0];
        int ret = A[0];
    
        for (int i = 1; i < n; i++) {
            if (min == 0 || max == 0) {
                int temp = max;
                max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
                min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
                ret = Math.max(max, ret);
                continue;
            }
    
    
            if (A[i] > 0) {
                if (min > 0) {
                    min = A[i];
                    max *= A[i];
                } else if (max < 0) {
                    min *= A[i];
                    max = A[i];
                } else {
                    min *= A[i];
                    max *= A[i];
                }
            } else if (A[i] < 0) {
                if (min > 0) {
                    min = max * A[i];
                    max = A[i];
                } else if (max < 0) {
                    max = min * A[i];
                    min = A[i];
                } else {
                    int temp = min;
                    min = max * A[i];
                    max = temp * A[i];
                }                
            } else {
                min = 0;
                max = 0;
            }

            if (max > ret) {
                ret = max;
            }
        }

        return ret;
    }
}