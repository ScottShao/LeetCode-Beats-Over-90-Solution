public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        char[] v1 = a.toCharArray();
        char[] v2 = b.toCharArray();
        int i1 = v1.length - 1;
        int i2 = v2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 && i2 >= 0) {
            int num = v1[i1] - '0' + v2[i2] - '0' + carry;
            sb.append(num % 2);
            carry = num / 2;
            i1--;
            i2--;
        }
        if (i1 >= 0) {
            for (int i = i1; i >= 0; i--) {
                int num = v1[i] - '0' + carry;
                sb.append(num % 2);
                carry = num / 2;
            }
        } else if (i2 >= 0) {
            for (int i = i2; i >= 0; i--) {
                int num = v2[i] - '0' + carry;
                sb.append(num % 2);
                carry = num / 2;
            }
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();   
    }
}