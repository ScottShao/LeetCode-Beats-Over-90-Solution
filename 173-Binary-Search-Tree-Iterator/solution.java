/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode crt;
    public BSTIterator(TreeNode root) {
        crt = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return crt != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (crt.left != null) {
            TreeNode temp = crt.left;
            while (temp.right != null && temp.right != crt) temp = temp.right;
            if (temp.right == null) {
                temp.right = crt;
                crt = crt.left;
            } else {
                temp.right = null;
                break;
            }
        }
        int re = crt.val;
        crt = crt.right;
        return re;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */