/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        if (temp != null) {
            node.val = temp.val;
            node.next = temp.next;
        }
    }
}