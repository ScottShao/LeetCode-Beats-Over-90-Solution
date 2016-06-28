public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int maxLen = 0;
        for (String word : wordDict) maxLen = Math.max(maxLen, word.length());
        return dfs(s.toCharArray(), 0, maxLen, wordDict, new HashSet<>(), new HashMap<>());
    }
    
    private List<String> dfs(char[] vals, int index, int maxLen, Set<String> wordDict, Set<Integer> notQualified, Map<Integer, List<String>> wordsMap) {
        if (index >= vals.length) {
            return null;
        }
        List<String> found = wordsMap.get(index);
        if (found != null) {
            return found;
        }
        found = new ArrayList<>();
        boolean isPathFound = false;
        for (int i = index; i <= index + maxLen && i < vals.length; i++) {
            String temp = new String(vals, index, i - index + 1);
            if (wordDict.contains(temp)) {
                if (!notQualified.contains(i + 1)) {
                    List<String> next = dfs(vals, i + 1, maxLen, wordDict, notQualified, wordsMap);
                    if (next == null || next.size() > 0) {
                        isPathFound = true;
                        if (next == null) {
                            found.add(temp);
                        } else {
                            for (String n : next) {
                                found.add(temp + " " + n);
                            }
                        }
                    }
                    
                }
            }
            
        }
        wordsMap.put(index, found);
        if (!isPathFound) notQualified.add(index);
        return found;
    }
}