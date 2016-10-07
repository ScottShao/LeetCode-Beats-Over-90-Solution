public class Solution {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int count = 0;
        int idx = 0;
        int len = nums.length;
        while (missing <= n) {
            if (idx < len && nums[idx] <= missing) {
                missing += nums[idx];
                idx++;
            } else {
                missing += missing;
                count++;
            }
        }
        return count;
    }
}