/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = dummyHead;
        int step = 0;
        while (fast != null) {
            if (step >= n) {
                slow = slow.next;
            }
            fast = fast.next;
            step++;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}