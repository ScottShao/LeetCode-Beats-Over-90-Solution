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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode crt = root;
        while (!stack.isEmpty() || crt != null) {
            if (crt != null) {
                stack.push(crt);
                crt = crt.left;
            } else {
                crt = stack.pop();
                k--;
                if (k == 0) {
                    return crt.val;
                }
                crt = crt.right;
            }
        }
        return -1;
    }
}