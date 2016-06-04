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
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode crt = start;
            while (crt != null) {
                if (crt.left != null) { 
                    crt.left.next = crt.right;
                    if (crt.next != null)  {
                        crt.right.next = crt.next.left;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                crt = crt.next;
            }
            start = start.left;
        }
    }
}