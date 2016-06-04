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
        while (root.left != null) {
            for (TreeLinkNode cur = root; cur != null; cur = cur.next) {
                if (cur.left == null) break;
                cur.left.next = cur.right;
                if (cur.next == null) break;
                cur.right.next = cur.next.left;
            }
            root = root.left;
        }
    }
}