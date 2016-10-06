public class Solution {
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        Arrays.sort(nums);
        dp[0] = 1;
        return helper(nums, target);
    }
    
    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            } else {
                break;
            }
        }
        dp[target] = res;
        return res;
    }
}