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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }else if (start == end) {
            return new TreeNode(nums[start]);
        } else {
            int mid = start + ((end - start + 1) >>> 1);
            TreeNode crt = new TreeNode(nums[mid]);
            crt.left = sortedArrayToBST(nums, start, mid - 1);
            crt.right = sortedArrayToBST(nums, mid + 1, end);
            return crt;
        }
        
    }
}