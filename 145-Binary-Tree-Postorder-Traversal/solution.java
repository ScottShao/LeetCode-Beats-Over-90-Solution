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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode crt = root;
        while (!stack.isEmpty() || crt != null) {
            if (crt != null) {
                stack.push(crt);
                results.addFirst(crt.val);
                crt = crt.right;
            } else {
                crt = stack.pop();
                crt = crt.left;
            }
        }

        return results;
    }
}