public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> chToStr = new HashMap<>();
        Map<String, Character> strToCh = new HashMap<>();
        String[] words = str.split(" ");
        char[] val = pattern.toCharArray();
        int n = val.length;
        if (n != words.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            String oldStr = chToStr.put(val[i], words[i]);
            if (oldStr != null && !oldStr.equals(words[i])) {
                return false;
            }
            Character oldCh = strToCh.put(words[i], val[i]);
            if (oldCh != null && oldCh != val[i]) {
                return false;
            }
        }
        return true;
    }
}