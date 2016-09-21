public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null) throw new IllegalArgumentException("input is null!");
        int len = nums.length;
        int re = -1;
        int index = 0;
        while (index < len) {
            if (nums[index] != index) {
                if (nums[index] != len) {
                    int temp = nums[nums[index]];
                    nums[nums[index]] = nums[index];
                    nums[index] = temp;
                } else {
                    re = index++;
                }
            } else {
                index++;
            }
        }
        return re == -1 ? len : re;
    }
}