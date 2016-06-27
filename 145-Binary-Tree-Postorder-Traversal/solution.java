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
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> leftChildren = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null) {
            result.addFirst(node.val);
            if (node.left != null) {
                leftChildren.push(node.left);
            }
            node = node.right;
            if (node == null && !leftChildren.isEmpty()) {
                node = leftChildren.pop();
            }
        }
        return result;
    }
}