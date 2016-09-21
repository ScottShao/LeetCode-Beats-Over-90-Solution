public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visiting = new boolean[n];
        if (dfs(-1, 0, visiting, graph) != n) return false;
        return true;
    }
    
    private int dfs(int prev, int crt, boolean[] visiting, List<List<Integer>> graph) {
        if (visiting[crt]) return -1;
        List<Integer> edges = graph.get(crt);
        visiting[crt] = true;
        int count = 0;
        for (int next : edges) {
            if (next != prev) {
                int temp = dfs(crt, next, visiting, graph);
                if (temp < 0) return -1;
                count += temp;
            }
        }
        count++;
        visiting[crt] = false;
        return count;
    }
}