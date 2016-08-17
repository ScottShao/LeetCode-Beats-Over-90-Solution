public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null | num2.length() == 0) {
            return null;
        }
        char[] vals1 = num1.toCharArray();
        char[] vals2 = num2.toCharArray();
        int l1 = vals1.length;
        int l2 = vals2.length;
        if (l1 == 1 && vals1[0] == '0' || l2 == 1 && vals2[0] == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0, len = l1 + l2 - 1; i < len; i++) {
            int sum = carry;
            for (int j = l1 - 1; l1 - j - 1 <= i && j >= 0; j--) {
                int idx = i - l1 + j + 1;
                if (idx < l2) {
                    sum += (vals1[j] - '0') * (vals2[l2 - idx - 1] - '0');
                }
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}