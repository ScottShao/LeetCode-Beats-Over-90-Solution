/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode crt = head;
        while (crt != null && count < k) {
            crt = crt.next;
            count++;
        }
        
        if (count < k) {
            return head;
        } else {
            ListNode prev = null;
            crt = head;
            
            for (int i = 0; i < k; i++) {
                ListNode temp = crt.next;
                crt.next = prev;
                prev = crt;
                crt = temp;
            }
            
            head.next = reverseKGroup(crt, k);
            return prev;
        }
    }
}