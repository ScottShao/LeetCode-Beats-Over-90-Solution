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
    private boolean found = false;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return re;
    }
    
    private void inorder(TreeNode root, int k) {
        if (!found && root != null) {
            inorder(root.left, k);
            if (++crt == k) {
                re = root.val;
                found = true;
                return;
            }
            inorder(root.right, k);
        }
    }
}