public class Solution {
    private final int MAX_DUPLICATES = 2;   
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = nums[0];
        int count = 1;
        int crt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                count = 1;
                prev = nums[i];
            } else {
                count++;
            }
            
            if (count <= MAX_DUPLICATES) {
                nums[crt] = nums[i];
                crt++;
            }
        }
        return crt;
    }
}