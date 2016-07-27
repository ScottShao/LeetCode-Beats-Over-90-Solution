public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }   
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] vals = s.toCharArray();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (char ch : vals) {
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || map.get(ch) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}