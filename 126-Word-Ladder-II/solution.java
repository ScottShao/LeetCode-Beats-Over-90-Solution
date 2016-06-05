public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.add(list);
        int level = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            Set<String> visiting = new HashSet<>();
            for (int i = 0, len = queue.size(); i < len; i++) {
                List<String> top = queue.poll();
                String last = top.get(level);
                for (int m = 0, size = last.length(); m < size; m++) {
                    StringBuilder sb = new StringBuilder(last);
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(m, j);
                        String s = sb.toString();
                        if (wordList.contains(s) && !visited.contains(s)) {
                            List<String> next = new ArrayList<>(top);
                            next.add(s);
                            queue.add(next);
                            visiting.add(s);
                            if (s.equals(endWord)) {
                                ladders.add(next);
                            }
                        }
                    }
                }
            }
            if (ladders.size() > 0) break;
            level++;
            visited.addAll(visiting);
        }
        
        return ladders;
    }
}