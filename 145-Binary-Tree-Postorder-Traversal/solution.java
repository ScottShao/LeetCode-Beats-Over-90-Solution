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
        ArrayDeque<Integer> results = new ArrayDeque<>();
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
        List<Integer> re = new ArrayList<>(results.size());
        for (int val : results) {
            re.add(val);
        }
        return re;
    }
}