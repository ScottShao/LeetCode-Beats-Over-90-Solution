public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] re = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return re;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >>> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[low] != target) {
            return re;
        } 
        re[0] = low;
        high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low + 1) >>> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        re[1] = low;
        return re;
    }
}