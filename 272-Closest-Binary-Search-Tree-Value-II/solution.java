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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (k == 0) return res;
        Queue<TreeNode> pq = new PriorityQueue<>(new Comparator<TreeNode>() {
            public int compare(TreeNode t1, TreeNode t2) {
                if (Math.abs(t1.val - target) < Math.abs(t2.val - target)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        dfs(root, target, pq);
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().val);
        }
        return res;
    }
    
    private void dfs(TreeNode root, double target, Queue<TreeNode> pq) {
        if (root == null) return;
        pq.add(root);
        dfs(root.left, target, pq);
        dfs(root.right, target, pq);
    }
}