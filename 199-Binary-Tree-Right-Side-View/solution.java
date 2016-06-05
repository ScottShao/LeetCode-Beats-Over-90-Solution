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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if (root == null) {
            return view;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode last = queue.getLast();
            view.add(last.val);
            
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode top = queue.poll();
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
            }
        }
        return view;
    }
}