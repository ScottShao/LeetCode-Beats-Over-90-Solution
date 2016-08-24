public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int idx = digits.length - 1;
        do {
            digits[idx]++;
            carry = digits[idx] / 10;
            digits[idx] = digits[idx] % 10;
            idx--;
        } while (idx >= 0 && carry != 0);
        int[] re = null;
        if (carry != 0) {
            re = new int[digits.length + 1];
            re[0] = carry;
            for (int i = 1; i < digits.length; i++) {
                re[i] = digits[i - 1];
            }
        } else {
            re = digits;
        }
        return re;
    }
}