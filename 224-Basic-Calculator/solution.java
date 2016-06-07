public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        Stack<Integer> exStack = new Stack<>();
        int sign = 1;
        int result = 0;
        int val = 0;
        
        for (char ch : chs) {
            switch(ch) {
                case ' ':
                    continue;
                case '+':
                    result += sign * val;
                    val = 0;
                    sign = 1;
                    break;
                case '-':
                    result += sign * val;
                    val = 0;
                    sign = -1;
                    break;
                case '(':
                    exStack.push(result);
                    exStack.push(sign);
                    sign = 1;
                    result = 0;
                    break;
                case ')':
                    result += sign * val;
                    result = result * exStack.pop() + exStack.pop();
                    val = 0;
                    break;
                default:
                    val = val * 10 + ch - '0';
            }
        }
        
        return result + sign * val;
    }
}