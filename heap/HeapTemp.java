package heap;

public class HeapTemp {
    int[] h;
    int size;
    // 建立堆 o(n)
    void setUp(){
        for (int i = h.length / 2; i > 0; i--) {
            down(i);
        }
    }

    // 向下调整
    void down(int x){
        // 找到三者中最小值进行替换
        int m = x;
        if (size >= 2*x && h[2*x] < h[m]) m = 2 * x;
        if (size >= 2*x+1 && h[2*x+1] < h[m]) m = 2*x+1;
        if (m!=x){
            int t = h[x];
            h[x] = h[m];
            h[m] = t;
            down(m);
        }
    }

    // 向上调整
    void up(int x){
        // 比较父节点即可
        while (x/2 > 0 && h[x/2] > h[x]){
            int t = h[x/2];
            h[x/2] = h[x];
            h[x] = t;
        }
    }

    // 删除最小值
    void delMin(){
        h[1] = h[size];
        size--;
        down(1);
    }

}