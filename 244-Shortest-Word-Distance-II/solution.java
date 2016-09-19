public class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.get(words[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(words[i], list);
            }
            list.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int minDis = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < l1.size() && j < l2.size();) {
            int t1 = l1.get(i);
            int t2 = l2.get(j);
            if (t1 > t2) {
                minDis = Math.min(minDis, t1 - t2);
                j++;
            } else {
                minDis = Math.min(minDis, t2 - t1);
                i++;
            }
        }
        return minDis;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");