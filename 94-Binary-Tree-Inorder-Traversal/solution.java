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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode crt = root;
        while (!stack.isEmpty() || crt != null) {
            if (crt != null) {
                stack.push(crt);
                crt = crt.left;
            } else {
                crt = stack.pop();
                results.add(crt.val);
                crt = crt.right;
            }
        }
        return results;
    }
}