public class Solution {
    private final String[] SCALES = {"Billion","Million", "Thousand", "Hundred"};
    private final String[] LESSTHANHUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", 
                                            "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] ONE2NINETEEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                                            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                                            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        numberToWords(num, sb);
        return sb.toString().trim();
    }
    
    private void numberToWords(int num, StringBuilder sb) {
        if (num == 0) {
            return; 
        } if (num < 20) {
            sb.append(" ").append(ONE2NINETEEN[num]);
        } else if (num < 100) {
            sb.append(" ").append(LESSTHANHUNDRED[num / 10]);
            numberToWords(num % 10, sb);
        } else if (num < 1000) {
            numberToWords(num / 100, sb);
            sb.append(" Hundred");
            numberToWords(num % 100, sb);
        } else if (num < 1000000) {
            numberToWords(num / 1000, sb);
            sb.append(" Thousand");
            numberToWords(num % 1000, sb);
        } else if (num < 1000000000) {
            numberToWords(num / 1000000, sb);
            sb.append(" Million");
            numberToWords(num % 1000000, sb);
        } else {
            numberToWords(num / 1000000000, sb);
            sb.append(" Billion");
            numberToWords(num % 1000000000, sb);
        }
    }
}