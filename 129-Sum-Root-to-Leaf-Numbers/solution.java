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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int crt) {
        if (root == null) {
            return 0;
        } else {
            crt = crt * 10 + root.val;
            if (root.left == null && root.right == null) {
                return crt;
            } else {
                return dfs(root.left, crt) + dfs(root.right, crt);
            }
        }
    }
}