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
    int counter = 0, k;
    int rt = 0;

    public void inorder(TreeNode root) {
        if (counter == k || root == null)
            return;

        if (root.left != null)
            inorder( root.left);

        if (counter != k) {
            rt = root.val;
            counter++;
        }

        if (root.right != null)
            inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return rt;
    }
}