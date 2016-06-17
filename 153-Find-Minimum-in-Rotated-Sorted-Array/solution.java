public class Solution {
    public int findMin(int[] nums) {
         // Do a binary search. Runs in O(log n) worst case.
        int lower = 0;
        int upper = nums.length;
        while (upper - lower > 1) {// Continue till we have only one element left in the range
            int mid = lower + upper >> 1;
            if (nums[mid] > nums[0])
                lower = mid;
            else
                upper = mid;
        }

        // lower points to maximum number, upper points to minimum.
        // In the special case where upper == nums.length, our minimum number will be at index 0.
        return nums[upper % nums.length];
    }
}