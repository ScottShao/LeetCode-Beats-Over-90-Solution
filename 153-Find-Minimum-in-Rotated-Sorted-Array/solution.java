public class Solution {
    public int findMin(int[] nums) {
        int high = nums.length;
        if (high == 0) {
            return -1;
        }
        high--;
        int low = 0;
        while (low < high) {
            int mid = low + ((high - low) >>> 1);
            if (nums[mid] > nums[low] && nums[mid] < nums[high]) {
                high = mid - 1;
            } else if (nums[mid] < nums[low] && nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[low] && nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                return Math.min(nums[low], nums[high]);
            }
        }
        return nums[low];
    }
}