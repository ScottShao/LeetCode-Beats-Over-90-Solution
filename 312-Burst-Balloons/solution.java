public class Solution {
    public int maxCoins(int[] iNums) {
        int n = iNums.length + 2;
        int[] nums = new int[n];
        int i = 1;
        for (int x : iNums) nums[i++] = x;
        nums[0] = nums[n - 1] = 1;
    
    
        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }
    
    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
            + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }
}