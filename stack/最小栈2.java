package stack;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    private Deque<Integer> dataStack;
    private Integer min;
    public MinStack() {
        dataStack = new LinkedList<>();
    }
    
    public void push(int val) {
        if(dataStack.isEmpty()){
            dataStack.push(0);
            min = val;
        }else{
            dataStack.push(val-min);
        }
    }
    
    public void pop() {
        min = dataStack.peek() < 0 ? dataStack.peek() + min: min;
        dataStack.pop();
    }
    
    public int top() {
        return min + dataStack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
