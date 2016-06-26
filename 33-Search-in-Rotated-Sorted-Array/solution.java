public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (nums[mid] > target) {
                if (target < nums[low] && nums[mid] >= nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (target > nums[high] && nums[mid] < nums[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}