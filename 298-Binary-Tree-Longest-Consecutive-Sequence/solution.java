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
    private int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        traversal(root);
        return max;
    }
    
    private int  traversal(TreeNode root){
        if (root == null) return 0;
        int left = traversal(root.left);
        int right = traversal(root.right);
        int crt = 0;
        if (left > 0 && root.val + 1 == root.left.val) crt = left;
        if (right > 0 && root.val + 1 == root.right.val) crt = Math.max(crt, right);
        ++crt;
        max = Math.max(crt, max);
        return crt;
    }
}