/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode crt = head;
        while (crt != null) {
            ListNode temp = crt.next;
            while (temp != null && temp.val == crt.val) {
                temp = temp.next;
            }
            if (temp == crt.next) {
                prev.next = crt;
                prev = crt;
            } else {
                prev.next = temp;
            }
            crt = temp;
        }
        return dummy.next;
    }
}