public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else if (n >= 10) {
            return 8877691;
        }
        int result = 9;
        int k = 9;
        int temp = n - 1;
        while (temp > 0) {
            result *= k;
            k--;
            temp--;
        }
        return result + countNumbersWithUniqueDigits(n - 1);
    }
}