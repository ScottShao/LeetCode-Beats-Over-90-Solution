public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> it = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) return it;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> pq = graph.get(ticket[0]);
            if (pq == null) {
                pq = new PriorityQueue<>();
                graph.put(ticket[0], pq);
            }
            pq.add(ticket[1]);
        }
        Stack<String> stack = new Stack<>();
        dfs(graph, "JFK", stack);
        while (!stack.isEmpty()) {
            it.add(stack.pop());
        }
        return it;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> graph, String crt, Stack<String> stack) {
        PriorityQueue<String> pq = graph.get(crt);
        while (pq != null && !pq.isEmpty()) {
            dfs(graph, pq.poll(), stack);
        }
        stack.push(crt);
    }
}