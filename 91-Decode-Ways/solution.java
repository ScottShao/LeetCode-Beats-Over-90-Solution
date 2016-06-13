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
        int prevNum = 1;
        int prepreNum = 1;
        for (int i = 2; i <= chs.length; i++) {
            int crt = chs[i - 1] - '0';
            int temp = prevNum;
            if (crt == 0) {
                if (prev > 2 || prev == 0) {
                    prevNum = 0;
                    break;
                }
                prevNum = prepreNum;
            } else {
                if (prev == 1 || (prev == 2 && crt <= 6)) {
                    prevNum += prepreNum;
                }
            }
            prev = crt;
            prepreNum = temp;
        }
        return prevNum;
    }
}