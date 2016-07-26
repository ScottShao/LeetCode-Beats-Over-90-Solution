public class Solution {
    private static final int[] values = {
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    };
    
    private static final String[] symbol = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    };
    
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int res = 0;
        while (s.length() > 0) {
            while (s.startsWith(symbol[i])) {
                res += values[i];
                s = s.substring(i % 2 + 1);
            }
            i++;
        }
        return res;
    }
}