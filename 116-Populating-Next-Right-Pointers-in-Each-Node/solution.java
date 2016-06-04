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
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode prev = dummy;
        while (root != null && root.left != null) {
            prev.next = root.left;
            root.left.next = root.right;
            prev = root.right;
            if (root.next == null) {
                root = dummy.next;
                prev = dummy;
            } else {
                root = root.next;
            }
        }
    }
}