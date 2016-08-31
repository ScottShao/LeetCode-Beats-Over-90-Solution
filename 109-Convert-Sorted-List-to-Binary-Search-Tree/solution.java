/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode crt = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        crt = head;
        while (crt != null) {
            crt = crt.next;
            size++;
        }
        crt = head;
        return sortedListToBST(0, size - 1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            int val = crt.val;
            crt = crt.next;
            return new TreeNode(val);
        } else {
            int mid = start + (end - start + 1) / 2;
            TreeNode left = sortedListToBST(start, mid - 1);
            TreeNode root = new TreeNode(crt.val);
            crt = crt.next;
            root.left = left;
            root.right = sortedListToBST(mid + 1, end);
            return root;
        }
    }
}