public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int step = 1;
        long base = 1;
        while (step * base * 9  < n) {
            n -= step * base * 9;
            step++;
            base *=10;
        }
        n--;
        base += n / step;
        String s = Long.toString(base);
		return Character.getNumericValue(s.charAt((n) % step));
    }
}