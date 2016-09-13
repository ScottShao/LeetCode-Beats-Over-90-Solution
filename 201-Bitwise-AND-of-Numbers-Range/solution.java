public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int x = m ^ n;
        int s = x >> 1;
        while (s > 0) {
            x = x | s;
            s >>= 1;
        }
        return m & n & ~x;
    }
}