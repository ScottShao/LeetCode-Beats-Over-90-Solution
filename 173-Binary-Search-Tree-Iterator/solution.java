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
    private Deque<TreeNode> stack;
    private TreeNode next;
    public BSTIterator(TreeNode root) {
        next = null;
        stack = new ArrayDeque<>();
        setNext(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return next != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int re;
        if (next == null) {
            TreeNode temp = stack.pop();
            re = temp.val;
            setNext(temp.right);
        } else {
            re = next.val;
            setNext(next.right);
        }
        return re;
    }
    
    private void setNext(TreeNode root){
        if (root == null) {
            next = null;
            return;
        }
        while (root.left != null) {
            stack.push(root);
            root = root.left;
        }
        next = root;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */