class MyQueue {
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        while (!output.isEmpty()) {
            input.push(output.pop());
        }
        input.push(x);
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    public void pop() {
        output.pop();
    }

    public int peek() {
        return output.peek();
    }

    public boolean empty() {
        return output.empty();
    }
}