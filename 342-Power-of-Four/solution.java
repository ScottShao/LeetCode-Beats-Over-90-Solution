public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        return (num & num - 1) == 0 && (num & 0xAAAAAAAA) == 0;   
    }
}