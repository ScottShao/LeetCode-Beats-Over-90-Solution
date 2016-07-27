/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode first = head;
        ListNode second = null;
        while (first != null) {
            second = first.next;
            if (second != null) {
                ListNode temp = second.next;
                prev.next = second;
                second.next = first;
                first.next = null;
                prev = first;
                first = temp;
            } else {
                prev.next = first;
                break;
            }
        }
        return dummyHead.next;
    }
}