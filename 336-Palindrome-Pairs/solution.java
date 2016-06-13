public class Solution {
    class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;
    
        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
    
        TrieNode root = new TrieNode();
    
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
    
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
    
        return res;
    }
    
    private void addWord(TrieNode root, String word, int index) {
        char[] chs = word.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            if (root.next[chs[i] - 'a'] == null) {
                root.next[chs[i] - 'a'] = new TrieNode();
            }
    
            if (isPalindrome(chs, 0, i)) {
                root.list.add(index);
            }
    
            root = root.next[chs[i] - 'a'];
        }
    
        root.list.add(index);
        root.index = index;
    }
    
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
        char[] chs = words[i].toCharArray();
        for (int j = 0; j < chs.length; j++) {   
            if (root.index >= 0 && root.index != i && isPalindrome(chs, j, chs.length - 1)) {
                list.add(Arrays.asList(i, root.index));
            }
    
            root = root.next[chs[j] - 'a'];
            if (root == null) return;
        }
    
        for (int j : root.list) {
            if (i == j) continue;
            list.add(Arrays.asList(i, j));
        }
    }
    
    private boolean isPalindrome(char[] word, int i, int j) {
        while (i < j) {
            if (word[i++] != word[j--]) return false;
        }
    
        return true;
    }
}