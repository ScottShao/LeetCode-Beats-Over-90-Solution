public class Solution {
    public int findPeakElement(int[] nums) {
        int index = 1;
        while (index < nums.length && nums[index] > nums[index - 1]) index++;
        return index - 1;
    }
}