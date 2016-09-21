public class Solution {
    class UnionFind {
        private int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int p) {
            int q = parent[p];
            while (parent[q] != parent[p]) {
                parent[p] = parent[q];
                q = parent[q];
            }
            return q;
        }
        
        public void union(int p, int q) {
            parent[p] = q;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (n < 1) return false;
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            int x = uf.find(e[0]);
            int y = uf.find(e[1]);
            if (x == y) return false;
            uf.union(x, y);
        }
        return edges.length == n - 1;
    }
}