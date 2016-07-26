public class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        x *= sign;
        int re = 0;
        while (x > 0) {
            int rem = x % 10;
            if (Integer.MAX_VALUE / 10 < re || (Integer.MAX_VALUE - rem) < re * 10) {
                return 0;
            }
            re = re * 10 + x % 10;
            x /= 10;
        }
        return sign * re;
    }
}