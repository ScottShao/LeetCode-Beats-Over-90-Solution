public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int step = 1;
        int base = 1;
        while ((long)step * base * 9  < (long)n) {
            n -= step * base * 9;
            step++;
            base *=10;
        }
        n--;
        base += n / step;
        String s = Integer.toString(base);
		return Character.getNumericValue(s.charAt((n) % step));
    }
}