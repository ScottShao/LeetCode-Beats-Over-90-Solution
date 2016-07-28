public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend > 0) {
            return -divide(-dividend, divisor);
        }
        if (divisor > 0) {
            return -divide(dividend, -divisor);
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        while (dividend <= divisor) {
            int crt = divisor;
            int multiplier = 1;
            while (crt > dividend - crt) {
                crt = crt << 1;
                multiplier = multiplier << 1;
            }
            dividend -= crt;
            res += multiplier;
        }
        return res;
    }
}