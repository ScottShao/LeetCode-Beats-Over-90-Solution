/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carry;
            carry = num / 10;
            num %= 10;
            prev.next = new ListNode(num);
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = l1.val + carry;
            carry = num / 10;
            num %= 10;
            prev.next = new ListNode(num);
            prev = prev.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int num = l2.val + carry;
            carry = num / 10;
            num %= 10;
            prev.next = new ListNode(num);
            prev = prev.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        return dummy.next;
    }
}