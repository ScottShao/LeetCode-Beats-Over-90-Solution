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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int len = inorder.length;
        Map<Integer, Integer> val2Idx = new HashMap<>();
        for (int i = 0; i < len; i++) {
            val2Idx.put(inorder[i], i);
        }
        return buildTree(inorder, 0, len - 1, postorder, len - 1, val2Idx);
    }
    
    private TreeNode buildTree(int[] inorder, int start, int end, int[] postorder, int crt, Map<Integer, Integer> val2Idx) {
        if (crt < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[crt]);
        int idx = val2Idx.get(postorder[crt]);
        if (idx < end) {
            root.right = buildTree(inorder, idx + 1, end, postorder, crt - 1, val2Idx);
        } 
        if (start < idx) {
            root.left = buildTree(inorder, start, idx - 1, postorder, crt - end + idx - 1, val2Idx);
        }
        return root;
    }
}