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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            List<TreeNode> re = new ArrayList<>();
            re.add(new TreeNode(left));
            return re;
        } else {
            List<TreeNode> re = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftList = generateTrees(left, i - 1);
                List<TreeNode> rightList = generateTrees(i + 1, right);
                if (leftList != null && rightList != null) {
                    for (TreeNode l : leftList) {
                        for (TreeNode r : rightList) {
                            TreeNode root = new TreeNode(i);
                            root.left = l;
                            root.right = r;
                            re.add(root);
                        }
                    }
                } else if (leftList == null){
                    for (TreeNode r : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.right = r;
                        re.add(root);
                    }
                } else {
                    for (TreeNode l : leftList) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        re.add(root);
                    }
                }
            }
            return re;
        }
    }
}