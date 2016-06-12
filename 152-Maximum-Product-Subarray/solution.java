public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int lo = 0, hi = 0, N = nums.length;
        int max = Integer.MIN_VALUE;
        int curr = 1;
    
        while (hi < N) {
            if (nums[hi] == 0 && curr < 0 && lo < hi - 1) {
                curr /= nums[lo++];
                max = Math.max(curr, max);
            }
            else if (nums[hi] == 0) {
                max = Math.max(0, max);
                lo = ++hi;
                curr = 1;
            } else {
                curr *= nums[hi++];
                max = Math.max(curr, max);
            }
        }
        for (; curr < 0 && lo < N - 1; lo++) {
            curr /= nums[lo];
            max = Math.max(curr, max);
        }
    
        return (int)max;
    }
    
}