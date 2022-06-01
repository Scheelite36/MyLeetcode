import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    private Stack<Integer> orderdStack;
    private Stack<Integer> reverseStack;

    public MyQueue() {
        orderdStack = new Stack<>();
        reverseStack = new Stack<>();
    }
    
    public void push(int x) {
        reverseStack.push(x);
    }
    
    public int pop() {
        arrange();
        return orderdStack.pop();
    }
    
    public int peek() {
        arrange();
        return orderdStack.peek();
    }
    
    public boolean empty() {
        return orderdStack.isEmpty() && reverseStack.isEmpty();
    }

    public void arrange() {
        if (orderdStack.isEmpty()) {
            while (!reverseStack.isEmpty()) {
                orderdStack.push(reverseStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

