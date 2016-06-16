public class Solution {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int crt = queue.poll();
                int sqrt = (int)Math.sqrt(crt);
                for (int j = sqrt; j > 0; j--) {
                    int next = crt - j * j;
                    if (next == 0) {
                        return level;
                    }
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}