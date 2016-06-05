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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if(null==root) return view;
        dfs(view, root, 1);
        return view;
    }
    private void dfs(List<Integer> view, TreeNode root, int layer){
        if(root == null) return;
        if(layer > view.size()) view.add(root.val);
        dfs(view, root.right, layer+1);
        dfs(view, root.left, layer+1);
    }
}