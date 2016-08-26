public class Solution {
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0 || S.length() < T.length())  return "";
        char[] sVal = S.toCharArray();
        char[] tVal = T.toCharArray();
        int sLen = sVal.length;
        int tLen = tVal.length;
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char c = tVal[i];
            int[] counts = map.get(c);
            if (counts == null) {
                counts = new int[1];
                map.put(c, counts);
            } 
            counts[0]++;
        }
        
        int count = 0, prev = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sLen; i++) {
            char currChar = sVal[i];
            int[] num = map.get(currChar);
            if (num != null) {    // if currChar exists in T
                // record currChar (when all T's chars are found, all map's value <= 0)
                num[0]--;
                // stop adding length (count) if we have more currChar's than T does (map's value < 0)
                if (num[0] >= 0)  count++;
                
                // S[prev, i] contains all T's chars, now shrink the left end (prev)
                while (count == tLen) {
                    char prevChar = sVal[prev];
                    int[] prevNum = map.get(prevChar);
                    if (prevNum != null) {   // if prevChar exists in T
                        prevNum[0]++; // recover map by adding the value back
                        if (prevNum[0] > 0) {   // S[pre, i] is the min substring ending at i
                            if (minLen > i - prev + 1) {
                                minLen = i - prev + 1;
                                minStart = prev;
                            }
                            count--;    // reduce count to end the while loop
                        }
                    }
                    prev++;
                }
            }
        }
        
        if (minLen == Integer.MAX_VALUE)    return "";
        else    return S.substring(minStart, minStart + minLen);
    }
}