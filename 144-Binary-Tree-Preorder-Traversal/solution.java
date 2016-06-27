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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode crt = root;
        while (!stack.isEmpty() || crt != null) {
            if (crt == null) {
                crt = stack.pop();
            } else {
                results.add(crt.val);
                if (crt.right != null) {
                    stack.push(crt.right);
                }
                crt = crt.left;
            }
        }
        return results;
    }
}