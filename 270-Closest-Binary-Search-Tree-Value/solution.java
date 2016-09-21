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
    private TreeNode low = null;
    private TreeNode high = null;
    public int closestValue(TreeNode root, double target) {
        traversal(root, target);
        if (low == null) return high.val;
        if (high == null) return low.val;
        if (target - low.val < high.val - target) {
            return low.val;
        } else {
            return high.val;
        }
    }
    
    private void traversal(TreeNode root, double target) {
        if (root == null) return;
        if (target > root.val) {
            low = root;
            traversal(root.right, target);
        } else if (target < root.val) {
            high = root;
            traversal(root.left, target);
        } else {
            low = root;
            high = root;
        }
    }
}