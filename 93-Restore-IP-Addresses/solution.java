public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return addresses;
        }
        dfs(s.toCharArray(), 0, 4, new StringBuilder(), addresses);
        return addresses;
    }
    
    private void dfs(char[] vals, int index, int left, StringBuilder sb, List<String> addresses) {
        int len = vals.length;
        if (left == 0 && index == len) {
            addresses.add(sb.substring(0, sb.length() - 1));
            return;
        } else if (left == 0 || index == len) {
            return;
        }
        int size = sb.length();
        for (int i = index; i < index + 3 && i < len; i++) {
            if (len - i - 1 <= 3 * left) {
                int val = 0;
                boolean isGood = true;
                for (int j = index; j <= i; j++) {
                    if (j > index && val == 0) {
                    	isGood = false;
                    	break;
                    }
                    val = val * 10 + vals[j] - '0';
                }
                if (isGood && val <= 255) {
                    sb.append(val).append('.');
                    dfs(vals, i + 1, left - 1, sb, addresses);
                    sb.setLength(size);
                }
            }
        }
    }
}