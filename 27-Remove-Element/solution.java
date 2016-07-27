public class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}