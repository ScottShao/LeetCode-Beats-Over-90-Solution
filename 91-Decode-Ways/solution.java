public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int[] nums = new int[chs.length + 1];
        int prev = chs[0] - '0';
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= chs.length; i++) {
            int crt = chs[i - 1] - '0';
            
            if (crt == 0) {
                if (prev > 2 || prev == 0) {
                    break;
                }
                nums[i] = nums[i - 2];
            } else {
                nums[i] = nums[i - 1];
                if (prev == 1 || (prev == 2 && crt <= 6)) {
                    nums[i] += nums[i - 2];
                }
            }
            prev = crt;
        }
        return nums[chs.length];
    }
}