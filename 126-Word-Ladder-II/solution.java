public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, List<String>> h = new HashMap<>();
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        beginSet.add(beginWord); 
        endSet.add(endWord);
        BFS(beginSet, endSet, wordList, h, true);

        List<List<String>> ans = new ArrayList();
        List<String> cur = new ArrayList();
        cur.add(beginWord);
        DFS(beginWord, endWord, h, cur, ans);
        return ans;
    }

    private void BFS(Set<String> beginSet, Set<String> endSet, Set<String> wordList, HashMap<String, List<String>> h, boolean forward) {
        if (beginSet.size() > endSet.size()) {
            BFS(endSet, beginSet, wordList, h, !forward);
            return;
        }
        wordList.removeAll(beginSet);
        wordList.removeAll(endSet);
        boolean connected = false;
        Set<String> nextSet = new HashSet();

        for (String s : beginSet) {
            char[] c = s.toCharArray();
            for (int i = 0, len = c.length; i < len; i++) {
                char ch = c[i];
                for (char x = 'a'; x <= 'z'; x++)
                    if (x != ch) {
                        c[i] = x;
                        String cand = new String(c);
                        if (endSet.contains(cand) || (!connected && wordList.contains(cand))) {
                            if (endSet.contains(cand))
                                connected = true;
                            else
                                nextSet.add(cand);

                            String next = forward ? cand : s;
                            String key = forward ? s : cand;
                            List<String> cur = h.containsKey(key) ? h.get(key) : new ArrayList();
                            cur.add(next);
                            h.put(key, cur);
                        }
                    }
                c[i] = ch;
            }
        }
        if (!connected && !nextSet.isEmpty())
            BFS(nextSet, endSet, wordList, h, forward);
    }

    private void DFS(String str, String ed, HashMap<String, List<String>> h, List<String> cur, List<List<String>> ans) {
        if (str.equals(ed)) {
            ans.add(new ArrayList(cur));
            return;
        }

        if (!h.containsKey(str)) return;
        List<String> next = h.get(str);
        for (String i : next) {
            cur.add(i);
            DFS(i, ed, h, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}