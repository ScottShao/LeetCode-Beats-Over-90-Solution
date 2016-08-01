public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int idx = n - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }
        if (idx < 0) {
            exchange(nums, 0, n - 1);
        } else {
            int find = idx + 1;
            while (find < n && nums[idx] < nums[find]) {
                find++;
            }
            find--;
            int temp = nums[idx];
            nums[idx] = nums[find];
            nums[find] = temp;
            exchange(nums, idx + 1, n - 1);
        }
    }
    
    private void exchange(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}