public class Solution {
    public int jump(int[] nums) {
        int jumps = 0, next = 0, max = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < lastIndex && next < lastIndex; i++) {
            max = Math.max(max, i + nums[i]);  // max: the farthest index to reach
            if (i == next) { // ready to jump
                if (max == next)    return -1;  // unreachable
                next = max; // next: next position to jump
                jumps++;
            }
        }
        return jumps;
    }
}