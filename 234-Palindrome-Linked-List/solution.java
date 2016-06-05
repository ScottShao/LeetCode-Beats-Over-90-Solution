/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {
            slow = slow.next;
        }
        
        ListNode prev = null;
        ListNode crt = slow;
        while (crt != null) {
            ListNode temp = crt.next;
            crt.next = prev;
            prev = crt;
            crt = temp;
        }
        
        while (prev != null && prev.val == head.val) {
            prev = prev.next;
            head = head.next;
        }
        return prev == null;
    }
}