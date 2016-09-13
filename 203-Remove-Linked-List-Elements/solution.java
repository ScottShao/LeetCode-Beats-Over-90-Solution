/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode crt = head;
        dummy.next = head;
        while (crt != null) {
            if (crt.val == val) {
                prev.next = crt.next;
            } else {
                prev = crt;
            }
            crt = crt.next;
        }
        return dummy.next;
    }
}