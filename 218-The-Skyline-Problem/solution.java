public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[] one : buildings) {
            heights.add(new int[]{one[0], -one[2]});
            heights.add(new int[]{one[1], one[2]});
        }
        Collections.sort(heights, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                if (i1[0] != i2[0]) {
                    return i1[0] - i2[0];
                } else {
                    return i1[1] - i2[1];
                }
            }
        });
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        pq.add(0);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.add(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int crt = pq.peek();
            if (crt != prev) {
                res.add(new int[]{h[0], crt});
                prev = crt;
            }
        }
        return res;
    }
}