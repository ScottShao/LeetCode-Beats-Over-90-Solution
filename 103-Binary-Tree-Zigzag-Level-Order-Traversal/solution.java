/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        boolean isFromLeft = true;
        que.add(root);
    
        while (!que.isEmpty()) {
            int size = que.size();
            LinkedList<Integer> lvl = new LinkedList<>();
            for (int i = 0; i < size; i++) {
               TreeNode temp = que.poll();
               if (temp.left != null) que.add(temp.left);
               if (temp.right != null) que.add(temp.right);
               if (isFromLeft) {
                   lvl.addLast(temp.val);
               } else {
                   lvl.addFirst(temp.val);
               }
            }
            isFromLeft = !isFromLeft;
            res.add(lvl);
        }
        return res;
    }
}