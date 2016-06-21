/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == 0 || n == 0 || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode crt = head;
        dummy.next = head;
        int idx = 1;
        while (idx < m) {
            crt = crt.next;
            prev = prev.next;
            idx++;
        }
        ListNode brokenFrom = prev;
        while (idx <= n) {
            ListNode temp = crt.next;
            crt.next = prev;
            prev = crt;
            crt = temp;
            idx++;
        }
        brokenFrom.next.next = crt;
        brokenFrom.next = prev;
        return dummy.next;
    }
}