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
        if (root == null) {
            return;
        }
        TreeLinkNode crt = root;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode prev = dummy;
        while (crt != null && crt.left != null) {
            prev.next = crt.left;
            crt.left.next = crt.right;
            prev = crt.right;
            if (crt.next == null) {
                crt = dummy.next;
                prev = dummy;
            } else {
                crt = crt.next;
            }
        }
    }
}