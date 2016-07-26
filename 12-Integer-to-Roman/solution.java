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
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                sb.append(symbol[i]);
                num -= values[i];
            }
            i++;
        }
        return sb.toString();
    }
}