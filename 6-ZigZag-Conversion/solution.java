public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder str = new StringBuilder();
        int skip1 = 2 * numRows - 2;
        int skip2 = skip1;
        char[] vals = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            if (i != 0 && i != numRows - 1)   skip2 -= 2;
            int index = i;
            while (index < s.length()) {
                str.append(vals[index]);
                if (i != 0 && i != numRows - 1 && index + skip2 < s.length())
                    str.append(vals[index + skip2]);
                index += skip1;
            }
        }
        return str.toString();
    }
}