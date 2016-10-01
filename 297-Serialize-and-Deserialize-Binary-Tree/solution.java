/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String spliter = "/";
    private static final String empty = "*";
    private int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(empty);
            sb.append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(spliter);
        index = 0;
        return deserialize(nodes);
    }
    
    private TreeNode deserialize(String[] nodes) {
        if (nodes[index].equals(empty)) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));