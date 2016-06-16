public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int [] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) { 
            if (!visited[i]) {
                if (!dfs(graph, i, visited, visiting, numCourses)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, int start, boolean[] visited, boolean[] visiting, int numCourses) {
        if (visiting[start]) {
            return false;
        }
        visiting[start] = true;
        List<Integer> nextNodes = graph[start];
        for (int node : nextNodes) {
            if (!dfs(graph, node, visited, visiting, numCourses)) {
                return false;
            }
            visited[node] = true;
        }
        visited[start] = true;
        visiting[start] = false;
        return true;
    }
}