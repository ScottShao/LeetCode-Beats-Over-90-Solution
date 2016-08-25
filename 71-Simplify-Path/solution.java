public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        int len = path.length();
        char[] vals = path.toCharArray();
        while (i < len) {
            if (vals[i] == '/') {
                int j = i + 1;
                while (j < len && vals[j] != '/') {
                    j++;
                }
                String current = new String(vals, i + 1, j - i - 1);
                if (current.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    if (!current.equals(".") && !current.equals("")) {
                        stack.push(current);
                    }
                }
                i = j;
            }
        }
        while (!stack.isEmpty()) {
            sb.append("/"+stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}