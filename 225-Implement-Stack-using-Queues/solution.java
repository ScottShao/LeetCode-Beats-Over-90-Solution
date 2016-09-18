class MyStack {
    Queue<Integer> q1, q2;
    
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> crt = q1.size() > 0 ? q1 : q2;
        crt.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        reverse();
    }

    // Get the top element.
    public int top() {
        int re = reverse();
        q2.add(re);
        return re;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }
    
    private int reverse() {
        Queue<Integer> temp;
        if (q2.size() > 0) {
            temp = q1;
            q1 = q2;
            q2 = temp;
        }
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        return q1.poll();
    }
}