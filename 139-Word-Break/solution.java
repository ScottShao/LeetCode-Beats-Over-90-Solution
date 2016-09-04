public class Solution {
    private int wordMinLen = Integer.MAX_VALUE;
    private int wordMaxLen = 0;
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        for (String str : wordDict) {
            int l = str.length();
            wordMinLen = Math.min(wordMinLen, l);
            wordMaxLen = Math.max(wordMaxLen, l);
        }
        char[] vals = s.toCharArray();
        return dfs(vals, 0, new HashSet<>(), wordDict);
    }
    
    private boolean dfs(char[] vals, int index, Set<Integer> visited, Set<String> wordDict) {
        if (index == vals.length) {
            return true;
        }
        if (visited.contains(index)) {
            return false;
        }
        for (int i = wordMinLen; i <= wordMaxLen && index + i <= vals.length; i++) {
            String next = new String(vals, index, i);
            if (wordDict.contains(next)) {
                if (dfs(vals, index + i, visited, wordDict)) {
                    return true;
                }
            }
        }
        visited.add(index);
        return false;
    }
    
    
}