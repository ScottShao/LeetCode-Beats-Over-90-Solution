public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder str = new StringBuilder();
        int skip1 = 2 * numRows - 2;
        int skip2 = skip1;
        char[] vals = s.toCharArray();
        int n = vals.length;
        for (int i = 0; i < numRows; i++) {
            if (i != 0 && i != numRows - 1)   skip2 -= 2;
            int index = i;
            while (index < n) {
                str.append(vals[index]);
                int temp = index + skip2;
                if (i != 0 && i != numRows - 1 &&  temp < n)
                    str.append(vals[temp]);
                index += skip1;
            }
        }
        return str.toString();
    }
}