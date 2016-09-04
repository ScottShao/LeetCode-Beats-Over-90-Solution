/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode crt = head;
        RandomListNode copyPrev = new RandomListNode(0);
        while (crt != null) {
            RandomListNode copy = map.get(crt);
            if (copy == null) {
                copy = new RandomListNode(crt.label);
                map.put(crt, copy);
            }
            copyPrev.next = copy;
            copyPrev = copy;
            if (crt.random != null) {
                copy = map.get(crt.random);
                if (copy == null) {
                    copy = new RandomListNode(crt.random.label);
                    map.put(crt.random, copy);
                }
                copyPrev.random = copy;
            }
            crt = crt.next;
        }
        return map.get(head);
    }
}