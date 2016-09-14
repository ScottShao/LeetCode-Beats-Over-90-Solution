public class WordDictionary {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
        
        public boolean containsKey(int val) {
            return children[val] != null;
        }
        
        public void addChild(int val) {
            children[val] = new TrieNode();
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] vals = word.toCharArray();
        TrieNode crt = root;
        for (char val : vals) {
            int idx = val - 'a';
            if (!crt.containsKey(idx)) {
                crt.addChild(idx);
            }
            crt = crt.children[idx];
        }
        crt.isWord = true;
    }
    
    public boolean search(char[] vals, int start, TrieNode crt) {
        if (crt == null) return false;
        if (start == vals.length) return crt.isWord;
        if (vals[start] == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(vals, start + 1, crt.children[i])) return true;
            }
            return false;
        } else {
            int idx = vals[start] - 'a';
            if (crt.containsKey(idx)) return search(vals, start + 1, crt.children[idx]);
            else return false;
        }
    }
        
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");