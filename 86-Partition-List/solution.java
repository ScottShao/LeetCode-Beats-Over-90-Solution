/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sDummy = new ListNode(0);
        ListNode gDummy = new ListNode(0);
        ListNode greater = gDummy;
        ListNode smaller = sDummy;
        ListNode crt = head;
        while (crt != null) {
            if (crt.val < x) {
                smaller.next = crt;
                smaller = smaller.next;
            } else {
                greater.next = crt;
                greater = greater.next;
            }
            crt = crt.next;
        }
        smaller.next = gDummy.next;
        greater.next = null;
        return sDummy.next;
    }
}