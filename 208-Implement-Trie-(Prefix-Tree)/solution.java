class TrieNode {
    boolean isWord;
    // Initialize your data structure here.
    TrieNode[] nodes;
    public TrieNode(boolean isWord) {
        this.isWord = isWord;
        this.nodes = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(false);
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] vals = word.toCharArray();
        TrieNode crt = root;
        for (char ch : vals) {
            int index = ch - 'a';
            if (crt.nodes[index] == null) {
                crt.nodes[index] = new TrieNode(false);
            }
            crt = crt.nodes[index];
        }
        crt.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] vals = word.toCharArray();
        TrieNode crt = root;
        for (char ch : vals) {
            int index = ch - 'a';
            if (crt.nodes[index] == null) return false;
            crt = crt.nodes[index];
        }
        return crt.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] vals = prefix.toCharArray();
        TrieNode crt = root;
        for (char ch : vals) {
            int index = ch - 'a';
            if (crt.nodes[index] == null) return false;
            crt = crt.nodes[index];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");