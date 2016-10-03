public class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int len) {
            parent = new int[len];
            rank = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
            count = 0;
        }
        
        public void union(int p, int q) {
            int p1 = find(p);
            int p2 = find(q);
            if (p1 == p2) return;
            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p1] < rank[p2]){
                parent[p1] = p2;
            } else {
                rank[p1]++;
                parent[p2] = p1;
            }
            count--;
        }
        
        public int find(int p) {
            int q = parent[p];
            while (q != parent[q]) {
                parent[p] = parent[q];
                q = parent[q];
            }
            return q;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        Set<Integer> used = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int[] p : positions) {
            int idx = p[0] * n + p[1];
            uf.count++;
            if (p[0] > 0 && used.contains(idx - n)) {
                uf.union(idx, idx - n);
            }
            if (p[0] < m - 1 && used.contains(idx + n)) {
                uf.union(idx, idx + n);
            }
            if (p[1] > 0 && used.contains(idx - 1)) {
                uf.union(idx, idx - 1);
            }
            if (p[1] < n - 1 && used.contains(idx + 1)) {
                uf.union(idx, idx + 1);
            }
            res.add(uf.count);
            used.add(idx);
        }
        return res;
    }
}