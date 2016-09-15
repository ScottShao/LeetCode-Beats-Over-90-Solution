public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int M = s.length(), N = t.length();
        if (M > N)  return isOneEditDistance(t, s);
        if (N - M > 1)  return false;
        
        int i = 0;
        while (i < M && s.charAt(i) == t.charAt(i)) i++;
        if (i == M) return N - M == 1;   // Append case
        if (M == N) {                    // Modify case
            i++;
            while (i < M && s.charAt(i) == t.charAt(i)) i++;
        } else /* if (N - M == 1) */ {   // Insert case
            while (i < M && s.charAt(i) == t.charAt(i + 1)) i++;
        }
        return i == M;
    }
}