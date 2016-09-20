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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(TreeNode crt, StringBuilder sb, List<String> res) {
        if (crt.left == null && crt.right == null) {
            sb.append(crt.val);
            res.add(sb.toString());
        } else {
            sb.append(crt.val).append("->");
            int len = sb.length();
            if (crt.left != null) dfs(crt.left, sb, res);
            sb.setLength(len);
            if (crt.right != null) dfs(crt.right, sb, res);
        }
    }
}