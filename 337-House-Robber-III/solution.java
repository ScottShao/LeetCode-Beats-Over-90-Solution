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
    public int rob(TreeNode root) {
        int[] re = cleverRob(root);
        return Math.max(re[0], re[1]);
    }
    
    private int[] cleverRob(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            int[] sum = new int[2];
            int[] left = cleverRob(root.left);
            int[] right = cleverRob(root.right);
            sum[0] = root.val + left[1] + right[1];
            sum[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return sum;
        }
    }
}