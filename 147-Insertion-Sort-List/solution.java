/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode crt = head;
        while (crt != null) {
            ListNode sortedList = dummy.next;
            ListNode prev = dummy;
            while (sortedList != null && crt.val >= sortedList.val) {
                sortedList = sortedList.next;
                prev = prev.next;
            }
            ListNode temp = crt.next;
            prev.next = crt;
            crt.next = sortedList;
            crt = temp;
        }
        return dummy.next;
    }
}