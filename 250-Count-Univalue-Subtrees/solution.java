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
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            count++;
            return 1;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left < 0 || right < 0) {
            return -1;
        } else {
            boolean re = left > 0 ? root.left.val == root.val : true;
            re = re && (right > 0 ? root.right.val == root.val : true);
            if (re) count++;
            return re ? 1 : -1;
        }
    }
    
}