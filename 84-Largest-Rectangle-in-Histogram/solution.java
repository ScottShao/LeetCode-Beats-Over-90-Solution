public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        int len = heights.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= len; i++) {
            int height = i == len ? 0 : heights[i];
            if (deque.isEmpty() || heights[deque.peek()] <= height) {
                deque.push(i);
            } else {
                int idx = deque.pop();
                max = Math.max(heights[idx] * (deque.isEmpty() ? i : i - deque.peek() - 1), max);
                i--;
            }
        }
        return max;
    }
}