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
        inorderTraversal(root, results);
        return results;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, results);
        results.add(root.val);
        inorderTraversal(root.right, results);
    }
}