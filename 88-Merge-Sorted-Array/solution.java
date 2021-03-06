public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int end = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            if (m < 0 || A[m] < B[n])   A[end--] = B[n--];
            else                        A[end--] = A[m--];
        }
    }
}