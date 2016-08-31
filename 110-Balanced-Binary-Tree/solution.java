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
    public boolean isBalanced(TreeNode root) {
        return maxDepthLR(root) != -1;
    }
    
    private int maxDepthLR(TreeNode root) {
        if (root == null) return 0;
        int L = maxDepthLR(root.left);
        if (L == -1) return -1;
        int R = maxDepthLR(root.right);
        if (R == -1) return -1;
        return (Math.abs(L - R) <= 1) ? Math.max(L, R) + 1 : -1;
    }
}