public class Solution {
    private static final int R = 26;
    private TrieNode root;
    private int m, n;
    
    class TrieNode {
        boolean isWord;
        TrieNode[] nodes;
        public TrieNode() {
            isWord = false;
            nodes = new TrieNode[R];
        }
    }
    
    private void insert(String word) {
        TrieNode crt = root;
        char[] vals = word.toCharArray();
        for (char val : vals) {
            int index = val - 'a';
            if (crt.nodes[index] == null) {
                crt.nodes[index] = new TrieNode();
            }
            crt = crt.nodes[index];
        }
        crt.isWord = true;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String str : words) {
            insert(str);
        }
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, visited, root, res, sb);
            }
        }
        return res;
    }
    
    
    
    private void dfs(char[][] board, int i, int j, boolean[][] visited, TrieNode crt, List<String> res, StringBuilder sb) {
        if (visited[i][j]) return;
        int index = board[i][j] - 'a';
        if (crt.nodes[index] == null) return;
        int len = sb.length();
        sb.append(board[i][j]);
        if (crt.nodes[index].isWord) { 
            res.add(sb.toString());
            crt.nodes[index].isWord = false;
        }
        visited[i][j] = true;
        if (i + 1 < m) dfs(board, i + 1, j, visited, crt.nodes[index], res, sb);
        if (i > 0) dfs(board, i - 1, j, visited, crt.nodes[index], res, sb);
        if (j + 1 < n) dfs(board, i, j + 1, visited, crt.nodes[index], res, sb);
        if (j > 0) dfs(board, i, j - 1, visited, crt.nodes[index], res, sb);
        sb.setLength(len);
        visited[i][j] = false;
    }
}