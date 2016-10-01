public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;
        if (preorder.equals("#")) return true;
        String[] nodes = preorder.split(",");
        int len = nodes.length;
        String[] stack = new String[len];
        int index = 0;
        int i;
        for (i = 0; i < len; i++) {
            String node = nodes[i];
            if (node.equals("#")) {
                if (index == 0) return false;
                while (index > 0 && stack[index - 1].equals("#")) {
                    index -= 2;
                }
                if (index == 0 && i < len - 1) break;
            } 
            stack[index++] = node;
        }
        return index == 1 && stack[0].equals("#");
    }
}