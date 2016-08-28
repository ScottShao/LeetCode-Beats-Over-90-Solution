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
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode crt = root;
        Integer prev = null;
        while (crt != null || !stack.isEmpty()) {
            if (crt == null) {
                crt = stack.pop();
                if (prev != null && prev >= crt.val) {
                    return false;
                }
                prev = crt.val;
                crt = crt.right;
            } else {
                stack.push(crt);
                crt = crt.left;
            } 
        }
        return true;
    }
}