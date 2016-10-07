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
    private int largestBSTSubtreeSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return largestBSTSubtreeSize;
    }
    
    private int[] helper(TreeNode root) {
        // return 3-element array:
        // # of nodes in the subtree, leftmost value, rightmost value
        // # of nodes in the subtree will be -1 if it is not a BST
        int[] result = new int[3];
        if (root == null) {
            return result;
        }
        int[] leftResult = helper(root.left);
        int[] rightResult = helper(root.right);
        if ((leftResult[0] == 0 || leftResult[0] > 0 && leftResult[2] <= root.val) &&
            (rightResult[0] == 0 || rightResult[0] > 0 && rightResult[1] >= root.val)) {
           int size = 1 + leftResult[0] + rightResult[0];
           largestBSTSubtreeSize = Math.max(largestBSTSubtreeSize, size);
           int leftBoundary = leftResult[0] == 0 ? root.val : leftResult[1];
           int rightBoundary = rightResult[0] == 0 ? root.val : rightResult[2];
           result[0] = size;
           result[1] = leftBoundary;
           result[2] = rightBoundary;
        } else {
        	result[0] = -1;
        }
        return result;
    }
}