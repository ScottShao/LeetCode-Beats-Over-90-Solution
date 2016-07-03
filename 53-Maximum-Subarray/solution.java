public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += prev;
            if (nums[i] < 0) {
                prev = 0;
            } else {
                prev = nums[i];
            }
            max = Math.max(nums[i], max);
        }
        return max;
    }
}