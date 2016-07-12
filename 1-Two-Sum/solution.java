public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int len = nums.length;
        int[] re = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer old = numMap.put(nums[i], i);
            if (old != null && nums[i] * 2 == target) {
                re[0] = old;
                re[1] = i;
                return re;
            }
        }
        for (int i = 0; i < len; i++) {
            int temp = target - nums[i];
            Integer idx = numMap.get(temp);
            if (idx != null && idx != i) {
                re[0] = idx;
                re[1] = i;
                break;
            }
        }
        return re;
    }
}