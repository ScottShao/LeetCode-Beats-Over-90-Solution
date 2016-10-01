public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 1) return new ArrayList<>();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        List<Integer> sources = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() <= 1) {
                sources.add(i);
            }
        }
        while (n > 2) {
            List<Integer> nextSources = new ArrayList<>();
            for (Integer idx : sources) {
                Integer adj = graph[idx].get(0);
                graph[adj].remove(idx);
                if (graph[adj].size() == 1) nextSources.add(adj); 
                n--;
            }
            sources = nextSources;
        }
        return sources;
    }
}