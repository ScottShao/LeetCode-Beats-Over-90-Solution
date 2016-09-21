public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                } else {
                    res += right - left;
                    left++;
                }
            }
        }
        return res;
    }
}