public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int [] p : prerequisites) {
            graph[p[0]].add(p[1]);
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
    
    private boolean dfs(List<Integer>[] graph, int start, int[] status, int numCourses) {
        if (status[start] == 1) {
            return false;
        }
        status[start] = 1;
        List<Integer> nextNodes = graph[start];
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