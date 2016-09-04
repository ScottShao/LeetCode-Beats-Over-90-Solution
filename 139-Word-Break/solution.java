public class Solution {
    private int wordMaxLen = 0;
    private int len = 0;
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        for (String str : wordDict) {
            int l = str.length();
            wordMaxLen = Math.max(wordMaxLen, l);
        }
        char[] vals = s.toCharArray();
        len = vals.length;
        return dfs(vals, 0, new boolean[len], wordDict);
    }
    
    private boolean dfs(char[] vals, int index, boolean[] visited, Set<String> wordDict) {
        if (index == len) {
            return true;
        }
        if (visited[index]) {
            return false;
        }
        for (int i = 1; i <= wordMaxLen && index + i <= len; i++) {
            String next = new String(vals, index, i);
            if (wordDict.contains(next)) {
                if (dfs(vals, index + i, visited, wordDict)) {
                    return true;
                }
            }
        }
        visited[index] = true;
        return false;
    }
    
    
}