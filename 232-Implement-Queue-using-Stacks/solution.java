class MyQueue {
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    int peek;
    
    public void push(int x) {
        if (input.empty()) {
            peek = x;
        }
        input.push(x);
    }

    public void pop() {
        while (!input.empty()) {
            output.push(input.pop());
        }
        output.pop();
        if (!output.empty()) {
            peek = output.peek();
        }
        while (!output.empty()) {
            input.push(output.pop());
        }
    }

    public int peek() {
        return peek;
    }

    public boolean empty() {
        return input.empty();
    }
}