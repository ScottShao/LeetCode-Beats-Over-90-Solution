public class Solution {
    public int trailingZeroes(int n) {
            // count how many 5's
        // # of zeros = floor(n/5) + floor(n/25) + floor(n/125) + ...
        int count = 0;
        while (n > 0) {
            n = n / 5; // use divide instead of multiplication to avoid overflow
            count += n;
        }
        return count;
    }
}