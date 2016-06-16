public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int [] p : prerequisites) {
            Set<Integer> set = graph.get(p[0]);
            set.add(p[1]);
        }
        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) { 
            if (status[i] == 0) {
                if (!dfs(graph, i, status, numCourses)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> graph, int start, int[] status, int numCourses) {
        if (status[start] == 1) {
            return false;
        }
        status[start] = 1;
        Set<Integer> nextNodes = graph.get(start);
        for (int node : nextNodes) {
            if (!dfs(graph, node, status, numCourses)) {
                return false;
            }
            status[node] = 2;
        }
        status[start] = 2;
        return true;
    }
}