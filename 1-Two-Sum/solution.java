public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++) 
             nums[i] = nums[i] * n + (nums[i] < 0 ? -i : i);
        
        Arrays.sort(nums);
        
        int lo = 0, hi = n - 1;
        // source tree test
        while (lo < hi) {
            int sum = nums[lo]/n + nums[hi]/n;
            if (sum == target) return new int[]{nums[lo] < 0 ? -nums[lo] % n : nums[lo] % n, nums[hi] < 0 ? -nums[hi] % n : nums[hi] % n};
            if (sum < target)   lo++;
            else                hi--;
        }
        throw new IllegalArgumentException();
    }
}
