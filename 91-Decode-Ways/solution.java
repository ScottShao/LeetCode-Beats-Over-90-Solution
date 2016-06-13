public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int prev = chs[0] - '0';
        if (prev == 0) {
            return 0;
        }
        int first = 1;
        int second = 1;
        for (int i = 1; i < chs.length; i++) {
            int crt = chs[i] - '0';
            int temp = second;
            if (crt == 0) {
                if (prev > 2 || prev == 0) {
                    second = 0;
                    break;
                }
                second = first;
            } else if (prev != 0 && prev * 10 + crt <= 26) {
                second += first;
            }
            prev = crt;
            first = temp;
        }
        return second;
    }
}