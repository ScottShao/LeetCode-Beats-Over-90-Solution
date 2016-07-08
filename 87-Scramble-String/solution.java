public class Solution {
    public boolean isScramble(String s1, String s2) {
        char[] v1 = s1.toCharArray();
        char[] v2 = s2.toCharArray();
        return isScramble(v1, 0, v1.length - 1, v2, 0, v2.length - 1);
    }
    
    private boolean isScramble(char[] v1, int start1, int end1, char[] v2, int start2, int end2) {
        int[] letters = new int[26];
        boolean isSame = true;
        for (int i = start1, j = start2; i <= end1; i++, j++) {
            letters[v1[i] -'a']++;
            letters[v2[j] -'a']--;
            isSame = isSame && v1[i] == v2[j];
        }
        if (isSame) return true;
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;
        for (int i = start1, j = start2; i < end1; i++, j++) {
            if (isScramble(v1, start1, i, v2, start2, j) 
             && isScramble(v1, i + 1, end1, v2, j + 1, end2)) return true;
            if (isScramble(v1, start1, i, v2, end2 - j + start2, end2) 
             && isScramble(v1, i + 1, end1, v2, start2, end2 - j + start2 - 1)) return true;
        }
        return false;
    }
}