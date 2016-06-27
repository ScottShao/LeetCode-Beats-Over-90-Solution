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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderTraversal(root, results);
        return results;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        results.add(root.val);
        preorderTraversal(root.left, results);
        preorderTraversal(root.right, results);
    }
}