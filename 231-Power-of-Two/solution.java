public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        while (n > 0) {
            if ((n & 1) == 1) {
                break;
            }
            n = n >> 1;
        }
        n = n >> 1;
        return n == 0;
    }
}