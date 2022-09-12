package queue;

/**
 * 数组模拟队列
 */
public class ArrayQueueTemp {
    int hh;
    int tt;
    int[] q;
    
    ArrayQueueTemp(int l){
        this.q = new int[l];
        this.tt = -1;
    }

    public void offer(int x){
        q[++tt] = x; 
    }

    public int poll(int x){
        return q[hh++];
    }

    boolean isEmpty(){
        return tt <= hh;
    }
}


