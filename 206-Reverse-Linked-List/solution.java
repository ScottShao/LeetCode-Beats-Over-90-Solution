/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode crt = head;
        ListNode next = head.next;
        crt.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = crt;
            crt = next;
            next = temp;
        }
        return crt;
    }
}