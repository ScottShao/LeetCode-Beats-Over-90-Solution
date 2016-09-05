/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            ListNode temp = slow.next;
            slow.next = null;
            slow = temp;
        } else {
            prev.next = null;
        }
        prev = null;
        ListNode p1 = slow;
        while (p1 != null) {
            ListNode temp = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = temp;
        }
        p1 = head;
        ListNode p2 = prev;
        while (p2 != null) {
            ListNode temp = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = temp;
            p1 = temp;
        }
    }
}