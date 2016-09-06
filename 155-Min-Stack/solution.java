public class MinStack {
    private int min;
    private Deque<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        min = Math.min(x, min);
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min) {
            resetMin();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
    
    private void resetMin() {
        min = Integer.MAX_VALUE;
        for (int num : stack) {
            min = Math.min(min, num);
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */