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
        ListNode crt = null;
        ListNode next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = crt;
            crt = next;
            next = temp;
        }
        return crt;
    }
}