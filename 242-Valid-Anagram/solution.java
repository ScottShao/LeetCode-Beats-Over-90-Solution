public class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m != n) {
            return false;
        }
        int[] counts = new int[256];
        char[] sVal = s.toCharArray();
        char[] tVal = t.toCharArray();
        for(char ch : sVal) {
            counts[ch]++;
        }
        
        for (char ch : tVal) {
            counts[ch]--;
            if (counts[ch] < 0) return false;
        }
        return true;
    }
}