public class Solution {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char[] vals = s.toCharArray();
        int start = -1;
        int max = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(i - start, max);
                    } else {
                        max = Math.max(i - stack.peek(), max);
                    }
                }
            }
        }
        return max;
    }
}