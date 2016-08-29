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
    public void recoverTree(TreeNode root) {
        TreeNode crt = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        while (crt != null) {
            if (crt.left == null) {
                if (prev != null && prev.val > crt.val) {
                    if (first == null) {
                        first = prev;
                        second = crt;
                    } else {
                        second = crt; 
                    }
                }
                prev = crt;
                crt = crt.right;
            } else {
                TreeNode temp = crt.left;
                while (temp.right != null && temp.right != crt) {
                    temp = temp.right;
                }
                
                if (temp.right == null) {
                    temp.right = crt;
                    crt = crt.left;
                } else { 
                    if (prev.val > crt.val) {
                        if (first == null) {
                            first = prev;
                            second = crt;
                        } else {
                            second = crt; 
                        }
                    }
                    prev = crt;
                    temp.right = null;
                    crt = crt.right;
                }
            }
        }
        if (first != null) {
            swap(first, second);
        }
    }
    
    private void swap(TreeNode t1, TreeNode t2) {
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
}