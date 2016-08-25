public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long crt = x;
        while (crt > x / crt) {
            crt = (x / crt + crt) / 2;
        }
        return (int) crt;
    }
}