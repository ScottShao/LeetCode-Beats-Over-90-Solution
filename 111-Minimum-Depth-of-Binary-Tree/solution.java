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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode crt = queue.poll();
                if (crt.left == null && crt.right == null) {
                    return level;
                } else {
                    if (crt.left != null) {
                        queue.add(crt.left);
                    } 
                    if (crt.right != null) {
                        queue.add(crt.right);
                    }
                }
            }
            level++;
        }
        return level;
    }
}