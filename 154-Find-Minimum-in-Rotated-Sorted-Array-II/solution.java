public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi && nums[lo] >= nums[hi]) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi])         lo = mid + 1;
            else if (nums[mid] < nums[hi])    hi = mid;
            else                            hi--;
        }
        return nums[lo];
    }
}