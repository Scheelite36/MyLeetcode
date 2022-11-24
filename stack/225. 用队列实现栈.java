package stack;

import java.util.Deque;
import java.util.LinkedList;


class MyStack {
    Deque<Integer> q1;
    Deque<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
    } 

    public int pop() {
        return q2.poll();
    }
    
    public int top() {
        return q2.peek();
    }
    
    public boolean empty() {
        return q2.isEmpty();
    }
}