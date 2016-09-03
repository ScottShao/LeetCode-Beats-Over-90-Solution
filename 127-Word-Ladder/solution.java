public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Deque<String> queue = new ArrayDeque<>();
        int depth = 1;
        int len = beginWord.length();
        queue.add(beginWord);
        wordList.remove(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] vals = queue.poll().toCharArray();
                for (int j = 0; j < len; j++) {
                    char  temp = vals[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != temp) {
                            vals[j] = ch;
                            String next = new String(vals);
                            if (next.equals(endWord)) {
                                return depth + 1;
                            }
                            if (wordList.contains(next)) {
                                queue.add(next);
                                wordList.remove(next);
                            }
                            vals[j] = temp;
                        }
                    }
                }
            }
            depth++;
        }
        return 0;
    }
}