/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int len = 0;
        ListNode crt = head;
        while (crt != null) {
            crt = crt.next;
            len++;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        dummy.next = head;
        ListNode left = null;
        ListNode right = null;
        for (int i = 1; i < len; i *= 2) {
            crt = dummy.next;
            tail = dummy;
            while (crt != null) {
                left = crt;
                right = move(crt, i);
                crt = move(right, i);
                tail = merge(tail, left, right);
            }
        }
        return dummy.next;
    }
    
    private ListNode merge(ListNode tail, ListNode l1, ListNode l2) {
        ListNode prev = tail;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) prev.next = l1;
        else prev.next = l2;
        while (prev.next != null) prev = prev.next;
        return prev;
    }
    
    private ListNode move(ListNode crt, int step) {
        step--;
        while (crt != null && step > 0) {
            crt = crt.next;
            step--;
        }
        if (crt == null) return null;
        ListNode re = crt.next;
        crt.next = null;
        return re;
    }
}