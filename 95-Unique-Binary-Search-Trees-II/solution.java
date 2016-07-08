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
        if(n==0) return new ArrayList<TreeNode>();
        return generateTress(1, n);
    }
    
    private List<TreeNode> generateTress(int start, int end){
        if(start>end) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        if(start==end) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(new TreeNode(start)); return list;
        }
        List<TreeNode> roots = new ArrayList<TreeNode>();
        for(int i=start;i<=end;i++){
            List<TreeNode> leftTrees = generateTress(start, i-1);
            List<TreeNode> rightTrees = generateTress(i+1, end);
            for(int j=0;j<leftTrees.size();j++){
                for(int k=0;k<rightTrees.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    roots.add(root);
                }
            }
            
        }
        return roots;
    }
}