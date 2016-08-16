public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int idx = 0;
        int len = nums.length;
        while (idx < nums.length) {
            if (nums[idx] <= 0 || nums[idx] > len || nums[nums[idx] - 1] == nums[idx]) {
                idx++;
                continue;
            }
            int temp = nums[nums[idx] - 1];
            nums[nums[idx] - 1] = nums[idx];
            nums[idx] = temp;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}