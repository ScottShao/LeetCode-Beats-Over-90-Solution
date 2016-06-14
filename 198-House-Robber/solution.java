public class Solution {
    public int rob(int[] nums) {
        int[] sum = new int[nums.length + 2];
        for (int i = 2; i < nums.length + 2; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i - 2]);
        }
        return sum[nums.length + 1];
    }
}