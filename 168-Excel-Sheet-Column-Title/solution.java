public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int rem = n % 26;
            n = n / 26;
            sb.append((char)('A' + rem));
        }
        return sb.reverse().toString();
    }
}