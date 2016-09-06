public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        int len = tokens.length;
        int[] stack = new int[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            String crt = tokens[i];
            index--;
            switch(crt) {
                case "*":
                    stack[index - 1] *= stack[index];
                    break;
                case "/":
                    stack[index - 1] /= stack[index];
                    break;
                case "+":
                    stack[index - 1] += stack[index];
                    break;
                case "-":
                    stack[index - 1] -= stack[index];
                    break;
                default:
                    index++;
                    stack[index] = Integer.valueOf(crt);
                    index++;
            }
        }
        return stack[0];
    }
}