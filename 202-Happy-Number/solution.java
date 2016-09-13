public class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        Set<Integer> seen = new HashSet<>();
        do {
            if (seen.contains(n)) return false;
            seen.add(n);
            int temp = 0;
            while (n > 0) {
                int rem = n % 10;
                temp += rem * rem;
                n = n / 10;
            }
            n = temp;
        } while (n != 1);
        return true;
    }
}