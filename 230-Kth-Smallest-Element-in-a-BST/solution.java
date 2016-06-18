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
    private int crt = 0;
    private int re = -1;
    private int k;
    private boolean found = false;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return re;
    }
    
    private void inorder(TreeNode root) {
        if (!found && root != null) {
            inorder(root.left);
            if (++crt == k) {
                re = root.val;
                found = true;
                return;
            }
            inorder(root.right);
        }
    }
}