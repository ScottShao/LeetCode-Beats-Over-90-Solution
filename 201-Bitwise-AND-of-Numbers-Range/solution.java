public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int mask = 1;
        while (mask <= n / 2) {
            mask = mask << 1;
        }
        int res = 0;
        while (((m & mask) ^ (n & mask)) == 0) {
            res += (m & mask);
            mask = mask >> 1;
        }
        return res;
    }
}