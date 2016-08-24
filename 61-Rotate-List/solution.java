/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode fast = head;
        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }
        k = k % len;
        fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            if (k > 0) {
                k--;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        fast.next = head;
        ListNode re = slow.next;
        slow.next = null;
        return re;
    }
}