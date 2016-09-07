public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append('-');
        } 
        long n = numerator;
        long d = denominator;
        n = Math.abs(n);
        d = Math.abs(d);
        sb.append(n / d);
        n %= d;
        if (n == 0) { 
            return sb.toString();
        } else {
            sb.append('.');
            Map<Long, Integer> val2Idx = new HashMap<>();
            while (n != 0) {
                n *= 10;
                long quot = n / d;
                Integer idx = val2Idx.get(n);
                if (idx != null) {
                    sb.insert((int)idx, '(');
                    sb.append(')');
                    break;
                } else {
                    val2Idx.put(n, sb.length());
                    sb.append(quot);
                }
                n %= d;
            }
            return sb.toString();
        }
    }
}