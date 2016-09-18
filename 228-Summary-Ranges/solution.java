public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            long crt = i == len ? nums[i - 1] : nums[i];
            long dif = crt - nums[i - 1];
            if (dif > 1 || dif == 0) {
                if (start + 1 < i) res.add(nums[start] + "->" + nums[i - 1]);
                else res.add(String.valueOf(nums[start]));
                start = i;
            }
        }
        return res;
    }
}