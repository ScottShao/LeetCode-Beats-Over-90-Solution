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
    private TreeNode re = null;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return inorder(root).val;
    }
    
    private TreeNode inorder(TreeNode root) {
        if (root == null) return null;
        TreeNode left = inorder(root.left);
        if (left != null) return left;
        k--;
        if (k == 0) return root;
        TreeNode right = inorder(root.right);
        if (right != null) return right;
        return null;
    }
}