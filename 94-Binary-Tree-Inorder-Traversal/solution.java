/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        traversal(root, results);
        return results;
    }
    
    private void traversal(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        traversal(root.left, results);
        results.add(root.val);
        traversal(root.right, results);
    }
}