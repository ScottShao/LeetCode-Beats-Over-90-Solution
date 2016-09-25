public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (n == 0) count++;
        }
        int idx = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[idx++] = n;
            }
        }
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}