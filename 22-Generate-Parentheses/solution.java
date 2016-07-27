public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if (n < 1) {
            return results;
        }
        dfs(0, 0, n, new StringBuilder(), results);
        return results;
    }
    
    private void dfs(int left, int right, int n, StringBuilder sb, List<String> results) {
        int len = left + right;
        if (left + right == 2 * n) {
            results.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(left + 1, right, n, sb, results);
            sb.setLength(len);
        }
        if (left > right) {
            sb.append(')');
            dfs(left, right + 1, n, sb, results);
            sb.setLength(len);
        }
    }
}