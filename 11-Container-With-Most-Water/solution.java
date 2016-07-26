public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int minHeight = height[left];
            if (height[right] > height[left]) {
                left++;
            } else {
                minHeight = height[right];
                right--;
            }
            max = Math.max(max, (right - left + 1) * minHeight);
            
        }
        return max;
    }
}