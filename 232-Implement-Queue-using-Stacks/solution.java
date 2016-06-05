class MyQueue {
    private Stack<Integer> pushTo = new Stack<Integer>();
    private Stack<Integer> pollFrom = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        pushTo.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        load();
        pollFrom.pop();
    }

    // Get the front element.
    public int peek() {
        load();
        return pollFrom.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushTo.isEmpty() && pollFrom.isEmpty();
    }
    
    private void load() {
        if (pollFrom.isEmpty()) {
            while(!pushTo.isEmpty()) {
                pollFrom.push(pushTo.pop());
            }
        }
    }
}