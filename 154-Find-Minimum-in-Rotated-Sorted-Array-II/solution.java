public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] == nums[low] || nums[mid] == nums[high] || nums[high] == nums[low]) {
                if (nums[low] < nums[high]) {
                    high--;
                } else {
                    low++;
                }
            } else if (nums[low] > nums[high]) {
                if (nums[mid] >= nums[low]) {
                    low = mid;
                } else {
                    high = mid;
                }
            } else {
                return nums[low];
            }
        }
        return nums[low];
    }
}