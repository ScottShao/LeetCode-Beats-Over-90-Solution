public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return true;
            } 
            if (nums[mid] <= nums[right]) {
                if (target >= nums[mid] && target <= nums[right]) 
                    left = mid + 1;
                else 
                    right--;
            } else {
                if (target <= nums[mid] && target >= nums[left]) 
                    right = mid - 1;
                else 
                    left++;
            }
        }
        return false;
    }
}