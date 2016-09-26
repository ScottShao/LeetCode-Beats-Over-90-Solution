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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode re = null;
        int dif = Integer.MAX_VALUE;
        while (root != null) {
            if (root.val > p.val) {
                int crtDif = root.val - p.val;
                if (crtDif < dif) {
                    dif = crtDif;
                    re = root;
                }
                root = root.left;
            } else {
                root = root.right;
            } 
        }
        return re;
    }
}