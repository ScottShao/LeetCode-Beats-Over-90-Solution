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
        ListNode crt = head;
        while (crt != null) {
            ListNode temp = crt.next;
            while (temp != null && temp.val == crt.val) {
                temp = temp.next;
            }
            crt.next = temp;
            crt = temp;
        }
        return head;
    }
}