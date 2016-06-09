public class Solution {
    private final int MAX_DUPLICATES = 2;   
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int n : nums) {
            if (idx < MAX_DUPLICATES || n > nums[idx - MAX_DUPLICATES]) {
                nums[idx++] = n;
            }
        }
        return idx;
    }
}