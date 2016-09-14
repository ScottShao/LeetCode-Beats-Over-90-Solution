public class Solution {
    private static final int R = 26;
    private static final int MASK = 256;
    private TrieNode root;
    private int m, n;
    
    class TrieNode {
        String word;
        TrieNode[] nodes;
        public TrieNode() {
            word = null;
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
        crt.word = word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String str : words) {
            insert(str);
        }
        m = board.length;
        n = board[0].length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    
    
    private void dfs(char[][] board, int i, int j, TrieNode crt, List<String> res) {
        if (board[i][j] >= MASK) return;
        int index = board[i][j] - 'a';
        if (crt.nodes[index] == null) return;
        if (crt.nodes[index].word != null) { 
            res.add(crt.nodes[index].word);
            crt.nodes[index].word = null;
        }
        board[i][j] ^= MASK;
        if (i + 1 < m) dfs(board, i + 1, j, crt.nodes[index], res);
        if (i > 0) dfs(board, i - 1, j, crt.nodes[index], res);
        if (j + 1 < n) dfs(board, i, j + 1, crt.nodes[index], res);
        if (j > 0) dfs(board, i, j - 1, crt.nodes[index], res);
        board[i][j] ^= MASK;
    }
}