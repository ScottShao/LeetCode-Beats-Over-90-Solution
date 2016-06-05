/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode h;
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        if (h == null) h = head;

        boolean tmp = true;        
        if (head.next != null) tmp &= isPalindrome(head.next);

        tmp &= (head.val == h.val);
        h = h.next;
        return tmp;
    }
}