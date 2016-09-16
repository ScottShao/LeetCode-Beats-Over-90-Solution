public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        lower--;
        upper++;
        int len = nums == null ? 0 : nums.length;
        int prev = lower;
        int crt;
        for (int i = 0; i <= len; i++) {
            crt = i < len ? nums[i] : upper;
            int dif = crt - prev;
            if (dif > 2) { 
                res.add((prev + 1) + "->" + (crt - 1));
            } else if (dif == 2) {
                res.add(String.valueOf(crt - 1));
            } 
            prev = crt;
        }
        return res;
    }
}