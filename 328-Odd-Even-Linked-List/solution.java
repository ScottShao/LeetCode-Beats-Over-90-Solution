/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode crt = even.next;
        ListNode evenHead = even;
        boolean isOdd = true;
        while (crt != null) {
            if (isOdd) {
                odd.next = crt;
                odd = crt;
            } else {
                even.next = crt;
                even = crt;
            }
            isOdd = !isOdd;
            crt = crt.next;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}