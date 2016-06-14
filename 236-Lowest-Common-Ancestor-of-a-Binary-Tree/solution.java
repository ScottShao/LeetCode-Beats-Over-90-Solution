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
    private TreeNode ancestor;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (p == null && q == null)) {
            return null;
        }
        if (q == null) {
            q = p;
        }
        if (p == null) {
            p = q;
        }
        search(root, p, q);
        return ancestor;
    }
    
    private int search(TreeNode crt, TreeNode p, TreeNode q) {
        if (crt == null || ancestor != null) {
            return 0;
        } else {
            int re = 0;
            if (crt == p || crt == q) {
                re++;
            }
            re += search(crt.left, p, q);
            if (re == 2) {
                ancestor = crt;
                return 0;
            }
            re += search(crt.right, p, q);
            if (re == 2) {
                ancestor = crt;
                return 0;
            }
            return re;
        }
    }
}