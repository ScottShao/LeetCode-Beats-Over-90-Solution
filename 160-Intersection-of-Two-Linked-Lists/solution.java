/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode p1 = null;
        ListNode p2 = null;
        p1 = headA;
        while (p1 != null) {
            p1 = p1.next;
            l1++;
        }
        p1 = headB;
        while (p1 != null) {
            p1 = p1.next;
            l2++;
        }
        int dif = l2 - l1;
        if (dif > 0) {
            p1 = headB;
            p2 = headA;
        } else {
            dif = -dif;
            p1 = headA;
            p2 = headB;
        }
        while (dif > 0) {
            p1 = p1.next;
            dif--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}