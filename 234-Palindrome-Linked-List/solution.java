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
        int len = 0;
        ListNode p = head, tmp, newHead = null;
        while (p != null) {
            p = p.next;
            ++len;
        }
        p = head;
        int halfLen = len >>> 1;
        for (int i = 0; i < halfLen; ++i) {
            tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        if (len % 2 == 1) {
            p = p.next;
        }
        for (int i = 0; i < halfLen; ++i) {
            if (newHead.val != p.val)
                return false;
            newHead = newHead.next;
            p = p.next;
        }
        return true;
    }
}