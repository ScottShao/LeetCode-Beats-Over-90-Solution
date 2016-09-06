public class Solution {
    public String reverseWords(String s) {
        if (s == null) return s;
        String[] words = s.split(" ");
        int len = words.length;
        if (len == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (words[i].length() > 0) sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}