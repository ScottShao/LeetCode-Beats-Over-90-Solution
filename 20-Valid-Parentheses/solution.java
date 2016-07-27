public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }   
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (char ch : s.toCharArray()) {
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