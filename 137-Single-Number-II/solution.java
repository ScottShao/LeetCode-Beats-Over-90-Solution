public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 1) bits[i]++;
                num = num >> 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res = res << 1;
            res ^= bits[i] % 3;
        }
        return res;
    }
}