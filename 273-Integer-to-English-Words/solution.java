public class Solution {
    private final String[] SCALES = {"Billion","Million", "Thousand", "Hundred"};
    private final String[] LESSTHANHUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", 
                                            "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] ONE2NINETEEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                                            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                                            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final int[] vals = {1000000000, 1000000, 1000, 100};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        numberToWords(num, sb);
        return sb.toString().trim();
    }
    
    private void numberToWords(int num, StringBuilder sb) {
        for (int i = 0; i < vals.length; i++) {
            if (num >= vals[i]) {
                numberToWords(num / vals[i], sb);
                sb.append(" ").append(SCALES[i]);
                num %= vals[i];
            }
        }
        
        int ties = num / 10;
        if (ties >= 2) {
            sb.append(" ").append(LESSTHANHUNDRED[ties]);
            num -= ties * 10;
        }
        if (num != 0) {
            sb.append(" ").append(ONE2NINETEEN[num]);
        }
    }
}