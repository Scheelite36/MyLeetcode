package stack;

/**
 * 数组模拟栈
 */
public class ArrayStackTemp{
    // 默认为-1；
    int tt;
    int[] stk;

    ArrayStackTemp(int l){
        this.stk = new int[l];
        this.tt = -1;
    }

    void push(int x){
        stk[++tt] = x;
    }
    int pop(){
        return stk[tt--];
    }
    boolean isEmpty(){
        return tt < 0;
    }

    int peek(){
        return stk[tt];
    }
}
