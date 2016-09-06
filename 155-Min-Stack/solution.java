public class MinStack {
    class IntPair {
        int num;
        int nextMin;    // the minVal when this new entry is pushed onto stack
        IntPair(int v1, int v2) {
            num = v1;
            nextMin = v2;
        }
    }
    
    Deque<IntPair> s;
    int minVal;

    /** initialize your data structure here. */
    public MinStack() {
        s = new ArrayDeque<>();
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        s.push(new IntPair(x, minVal) );
        minVal = Math.min(minVal, x);
    }
    
    public void pop() {
        IntPair curr = s.pop();
        
        // if the current minVal is popped, restore minVal to the minVal when this entry is pushed onto stack
        if (minVal == curr.num) minVal = curr.nextMin;
    }
    
    public int top() {
        return s.peek().num;
    }
    
    public int getMin() {
        return minVal;
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