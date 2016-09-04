public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];  // 32-bit integer
        int result = 0;
        for (int i = 0; i < 32; i++) {  // 1st loop must be bit: otherwise count % 3 will not be 0 or 1
            for (int num : nums)
                if (((num >> i) & 1) == 1)     count[i]++;
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
}