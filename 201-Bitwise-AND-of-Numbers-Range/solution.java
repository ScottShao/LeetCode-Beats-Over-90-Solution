public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = 1;
        while (mask <= n / 2) {
            mask = mask << 1;
        }
        int res = 0;
        int temp = 0;
        while (mask > 0 && ((temp = (m & mask)) ^ (n & mask)) == 0) {
            res += temp;
            mask = mask >> 1;
        }
        return res;
    }
}