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
    private int pi;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int len = preorder.length;
        Map<Integer, Integer> val2Idx = new HashMap<>();
        pi = 0;
        for (int i = 0; i < len; i++) {
            val2Idx.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, len - 1, val2Idx);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int ii, int ij, Map<Integer, Integer> val2Idx) {
        if (ii == ij) {
            return new TreeNode(inorder[ii]);
        }
        TreeNode root = new TreeNode(preorder[pi]);
        int idx = val2Idx.get(preorder[pi]);
        if (ii < idx) {
            pi++;
            root.left = buildTree(preorder, inorder, ii, idx - 1, val2Idx);
        }
        if (idx < ij) {
            pi++;
            root.right = buildTree(preorder, inorder, idx + 1, ij, val2Idx);
        }
        return root;
    }
}