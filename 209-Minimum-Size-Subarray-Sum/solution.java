public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0;
        int crt = 0;
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        while (right < len) {
            while (right < len && crt < s) {
                crt += nums[right];
                right++;
            }
            if (right >= len && crt < s) break;
            while (left < right && crt >= s) {
                crt -= nums[left];
                left++;
            }
            minLen = Math.min(right - left, minLen);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen + 1;
    }
}