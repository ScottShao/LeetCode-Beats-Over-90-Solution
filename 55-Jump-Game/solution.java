public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i <= max && i < lastIndex; i++) {
            max = Math.max(i + nums[i], max);
        }
        return max >= lastIndex;
    }
}