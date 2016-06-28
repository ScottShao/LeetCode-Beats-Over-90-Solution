public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        char[] vals = s.toCharArray();
        int maxLen = 0;
        for (String word : wordDict) maxLen = Math.max(maxLen, word.length());
        Map<Integer, List<String>> wordsMap = new HashMap<>();
        dfs(vals, 0, maxLen, new StringBuilder(), wordDict, wordsMap, new HashSet<>(), results);
        return results;
    }
    
    private boolean dfs(char[] vals, int index, int maxLen, StringBuilder sb, Set<String> wordDict, Map<Integer, List<String>> wordsMap, Set<Integer> notQualified, List<String> results) {
        if (index >= vals.length) {
            results.add(sb.toString().trim());
            return true;
        }
        int sbLen = sb.length();
        boolean isPathFound = false;
        for (int i = index; i <= index + maxLen && i < vals.length; i++) {
            String temp = new String(vals, index, i - index + 1);
            if (wordDict.contains(temp)) {
                if (!notQualified.contains(i + 1)) {
                    sb.append(temp).append(" ");
                    boolean isFound = dfs(vals, i + 1, maxLen, sb, wordDict, wordsMap, notQualified, results);
                    isPathFound = isPathFound || isFound;
                    sb.setLength(sbLen);
                }
            }
            
        }
        if (!isPathFound) notQualified.add(index);
        return isPathFound;
    }
}