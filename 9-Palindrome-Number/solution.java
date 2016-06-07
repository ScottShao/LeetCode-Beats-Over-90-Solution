public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int num = x;
        int len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }
        
        int low = (int)Math.pow(10, len >>> 1);
        num = x % low;
        x = len % 2 == 0 ? x / low : x / (low * 10);
        low /= 10;
        while (low > 0) {
            int k = num / low;
            if (k != x % 10) {
            	return false;
            }
            num -= k * low;
            low /= 10;
            x /= 10;
        }
        
        return true;
    }
}