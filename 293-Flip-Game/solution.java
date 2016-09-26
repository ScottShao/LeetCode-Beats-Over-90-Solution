public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        int len = s.length();
        if (len == 0) return res;
        char[] vals = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            if (vals[i] == '+' && vals[i + 1] == '+') {
                vals[i] = '-';
                vals[i + 1] = '-';
                res.add(new String(vals));
                vals[i] = '+';
                vals[i + 1] = '+';
            }
        }
        return res;
    }
}