public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        if (len == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len && nums[j] <= i; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}