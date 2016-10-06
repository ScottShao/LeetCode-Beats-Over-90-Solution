public class Solution {
    private final char[][] LETTER = new char[][]{{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g','h','i'}, {'j','k','l'}, {'m', 'n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null) return res;
        int len = digits.length();
        if (len == 0) return res;
        char[] chs = digits.toCharArray();
        dfs(chs, 0, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(char[] chs, int idx, StringBuilder sb, List<String> res) {
        if (idx == chs.length) {
            res.add(sb.toString());
        } else {
            char[] letters = LETTER[chs[idx] - '0'];
            int sbLen = sb.length();
            for (char ch : letters) {
                sb.append(ch);
                dfs(chs, idx + 1, sb, res);
                sb.setLength(sbLen);
            }
        }
    }
}