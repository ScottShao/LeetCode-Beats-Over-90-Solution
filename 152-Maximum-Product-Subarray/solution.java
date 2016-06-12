public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int maxRes = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] >= 0)
            {
                maxProduct = Math.max(maxProduct * nums[i], nums[i]);
                minProduct = Math.min(minProduct * nums[i], nums[i]);
            } else {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * nums[i], nums[i]);
                minProduct = Math.min(temp * nums[i], nums[i]);
            }
            maxRes = Math.max(maxRes, maxProduct);
        }
        return maxRes;
    }
}