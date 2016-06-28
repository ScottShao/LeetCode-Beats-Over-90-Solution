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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (ListNode ln : lists) {
            if (ln != null) {
                pq.add(ln);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode crt = dummy;
        while (!pq.isEmpty()) {
            crt.next = pq.poll();
            if (crt.next.next != null) {
                pq.add(crt.next.next);
            }
            crt = crt.next;
        }
        return dummy.next;
    }
}