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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int re = root.val;
        int temp = 0;
        if (left > 0) {
            re += left;
            temp = left;
        }  
        if (right > 0) {
            re += right;
            temp = Math.max(temp, right);
        }
        max = Math.max(max, re);
        return root.val + temp;
    }
}