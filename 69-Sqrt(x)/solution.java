public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long crt = x;
        long temp;
        while (crt > (temp = x / crt)) {
            crt = (temp + crt) / 2;
        }
        return (int) crt;
    }
}