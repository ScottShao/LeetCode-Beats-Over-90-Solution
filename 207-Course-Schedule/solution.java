public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int [] p : prerequisites) {
            if (graph[p[0]] == null) {
                graph[p[0]] = new ArrayList<Integer>();
            }
            graph[p[0]].add(p[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) { 
            if (!visited[i] && !dfs(graph, i, visited, visiting, numCourses)) {
                    return false;
            }
        }
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, int start, boolean[] visited, boolean[] visiting, int numCourses) {
        if (visiting[start]) {
            return false;
        }
        visiting[start] = true;
        if (graph[start] != null) {
            for (int node : graph[start]) {
                if (!dfs(graph, node, visited, visiting, numCourses)) {
                    return false;
                }
                visited[node] = true;
            }
        }
        visited[start] = true;
        visiting[start] = false;
        return true;
    }
}