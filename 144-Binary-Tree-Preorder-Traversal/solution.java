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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        TreeNode crt = root;
        while (crt != null) {
            if (crt.left == null) {
                results.add(crt.val);
                crt = crt.right;
            } else {
                TreeNode temp = crt.left;
                while (temp.right != null && temp.right != crt) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    results.add(crt.val);
                    temp.right = crt;
                    crt = crt.left;
                } else {
                    temp.right = null;
                    crt = crt.right;
                }
            }
        }
        return results;
    }
}