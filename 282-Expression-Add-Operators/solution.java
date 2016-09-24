public class Solution {
    private static final int MAX_INTDIV10 = Integer.MAX_VALUE / 10;
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        char[] vals = num.toCharArray();
        dfs(vals, 0, target, 0, 0, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(char[] vals, int idx, int target, long prev, long crt, StringBuilder sb, List<String> res) {
        int len = vals.length;
        if (idx == len) {
            if (crt == target) res.add(sb.toString());
        } else {
            long num = 0;
            for (int i = idx; i < len; i++) {
                int sbLen = sb.length();
                char ch = vals[i];
                if (vals[idx] == '0' && i != idx) {
                    break;
                }
                num = num * 10 + ch - '0';
                if (idx == 0) {
                    dfs(vals, i + 1, target, num, num, sb.append(num), res);
                    sb.setLength(sbLen);
                } else {
                    dfs(vals, i + 1, target, num, crt + num, sb.append('+').append(num), res);
                    sb.setLength(sbLen);
                    dfs(vals, i + 1, target, prev * num, crt - prev + prev * num, sb.append('*').append(num), res);
                    sb.setLength(sbLen);
                    dfs(vals, i + 1, target, -num, crt - num, sb.append('-').append(num), res);
                    sb.setLength(sbLen);
                }
                
            }
            
        }
    }
    
    
}