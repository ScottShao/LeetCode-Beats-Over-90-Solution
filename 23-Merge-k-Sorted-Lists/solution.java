/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        while (len > 1) {
            int last = len - 1;
            for (int i = 0, half = len / 2; i < half; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[last - i]);
            }
            len = (len + 1) >>> 1;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode dummy = new ListNode(-1);
        ListNode crt = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                crt.next = first;
                first = first.next;
            } else {
                crt.next = second;
                second = second.next;
            }
            crt = crt.next;
        }
        
        if (first == null) {
            crt.next = second;
        } else {
            crt.next = first;
        }
        
        return dummy.next;
    }
}