public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || k < 1) return new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i : nums) {
            int[] count = map.get(i);
            if (count == null) {
                count = new int[1];
                map.put(i, count);
            }
            count[0]++;
        }
        Queue<Map.Entry<Integer, int[]>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,int[]>>() {
            public int compare(Map.Entry<Integer, int[]> e1, Map.Entry<Integer, int[]> e2) {
                return e1.getValue()[0] - e2.getValue()[0];
            }
        });
        for (Map.Entry<Integer, int[]> en : map.entrySet()) {
            if (pq.size() < k || en.getValue()[0] > pq.peek().getValue()[0]) {
                
                pq.add(en);
                if (pq.size() > k) pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}