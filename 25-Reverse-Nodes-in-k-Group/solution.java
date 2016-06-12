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
        ListNode newHead = head;
        ListNode prevHead = new ListNode(-1);
        ListNode re = prevHead;
        while (newHead != null) {
            int count = 0;
            ListNode crt = newHead;
            while (crt != null && count != k) {
                crt = crt.next;
                count++;
            }
            
            if (count < k) {
                prevHead.next = newHead;
                break;
            } else {
                ListNode prev = null;
                crt = newHead;
                
                for (int i = 0; i < k; i++) {
                    ListNode temp = crt.next;
                    crt.next = prev;
                    prev = crt;
                    crt = temp;
                }
                
                prevHead.next = prev;
                prevHead = newHead;
                newHead = crt;
            }
        }
        return re.next;
    }
}