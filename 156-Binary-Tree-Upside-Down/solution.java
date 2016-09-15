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
    private TreeNode res;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        res = null;
        connect(root);
        return res;
    }
    
    private TreeNode connect(TreeNode root) {
        if (root == null) return null;
        TreeNode re = null;
        if (root.left == null) {
            if (res == null) res = root;
            re = root;
        } else {
            re = connect(root.left);
            re.right = root;
            re.left = root.right;
            root.left = null;
            root.right = null;
        }
        return root;
    }
}