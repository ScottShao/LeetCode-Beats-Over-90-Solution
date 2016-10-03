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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        Queue<Integer> indexes = new LinkedList<>();
        que.add(root);
        indexes.add(0);
        int min = 0;
        while (!que.isEmpty()) {
            int idx = indexes.poll();
            TreeNode node = que.poll();
            if (idx < min) {
                min = idx;
                res.add(0, new ArrayList<>());
            }
            int crt = idx - min;
            if (crt == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(crt).add(node.val);
            if (node.left != null) {
                que.add(node.left);
                indexes.add(idx - 1);
            }
            if (node.right != null) {
                que.add(node.right);
                indexes.add(idx + 1);
            }
        }
        return res;
    }
}