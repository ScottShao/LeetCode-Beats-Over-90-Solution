public class Solution {
    private static final int[] values = {
        1000, 500, 
        100, 50,
        10, 5,
        1
    };
    
    private static final char[] symbol = {
        'M', 'D',
        'C', 'L',
        'X', 'V',
        'I'
    };
    
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < symbol.length; i++)
            map.put(symbol[i], values[i]);
        
        int num = 0, prev = 0;
        char[] vals = s.toCharArray();
        for (int i = 0; i < vals.length; i++) {
            int curr = map.get(vals[i]);
            num += (curr > prev) ? (curr - 2 * prev) : curr;    // use subtractive rule
            prev = curr;
        }
        return num;
    }
}