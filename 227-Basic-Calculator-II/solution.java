public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] vals = s.toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int crt = 0;
        char sign = '+';
        
        for (char ch : vals) {
            if (ch == ' ') {
                continue;
            } else if (ch >= '0' && ch <= '9') {
                crt = 10 * crt + ch - '0';
            } else {
                if (sign == '+') {
                    stack.push(crt);
                } else if (sign == '-') {
                    stack.push(-crt);
                } else if (sign == '*') {
                    stack.push(stack.pop() * crt);
                } else if (sign == '/') {
                    stack.push(stack.pop() / crt);
                }
                crt = 0;
                sign = ch;
            }
        }
        if (sign == '+') {
            stack.push(crt);
        } else if (sign == '-') {
            stack.push(-crt);
        } else if (sign == '*') {
            stack.push(stack.pop() * crt);
        } else if (sign == '/') {
            stack.push(stack.pop() / crt);
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}