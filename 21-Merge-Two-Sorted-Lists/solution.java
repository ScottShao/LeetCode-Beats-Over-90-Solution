/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode crt = dummyHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                crt.next = p1;
                p1 = p1.next;
            } else {
                crt.next = p2;
                p2 = p2.next;
            }
            crt = crt.next;
        }
        crt.next = p1 == null ? p2 : p1;
        return dummyHead.next;
    }
}