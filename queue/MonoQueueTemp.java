package queue;

/**
 * 单调队列 找出滑动窗口中的最大最小值
 */
public class MonoQueueTemp {
    int[] nums;
    // 保存单调上升或下降的数组的下标
    int[] q;
    int hh = 0;
    int tt = -1;
    public void monoQueue(){
        for (int i = 0; i < nums.length; i++) {
            // 检查有没有出队列/出窗口
            while(hh<=tt && check_out(q[hh],i)) hh++;
            // 保持窗口单调性
            while(hh<=tt && check(q[tt],i)) tt--;
            q[++tt] = i;
            // 此时窗口的最大值就是q[hh]对应的东西
        }
    }
}
