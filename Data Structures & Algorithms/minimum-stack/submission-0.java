class MinStack {

    Deque<Integer> mainStack;
    Deque<Integer> stackForMin;

    public MinStack() {
        mainStack = new ArrayDeque<Integer>();
        stackForMin = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(stackForMin.isEmpty() || stackForMin.peek() >= val) {
            stackForMin.push(val);
        }
    }
    
    public void pop() {
        int val = mainStack.pop();
        if(stackForMin.peek() == val) {
            stackForMin.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return stackForMin.peek();
    }
}
