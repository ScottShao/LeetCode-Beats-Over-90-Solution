/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode dummy = new TreeLinkNode(0);
        while (root != null) {
            TreeLinkNode prev = dummy;
            dummy.next = null;
            for (TreeLinkNode crt = root; crt != null; crt = crt.next) {
                if (crt.left != null) {
                    prev.next = crt.left;
                    prev = prev.next;
                }
                if (crt.right != null) {
                    prev.next = crt.right;
                    prev = prev.next;
                }
            }
            root = dummy.next;
        }
    }
}