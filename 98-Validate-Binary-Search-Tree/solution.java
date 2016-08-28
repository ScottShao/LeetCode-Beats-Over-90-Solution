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
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    
    private boolean valid(TreeNode x, Integer low, Integer high) {
        if (x == null) return true;
        return (low == null || x.val > low) 
            && (high == null || x.val < high)
            && valid(x.left, low, x.val) 
            && valid(x.right, x.val, high);
    }
}