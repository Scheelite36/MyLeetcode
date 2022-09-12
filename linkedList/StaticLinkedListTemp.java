package linkedList;

/**
 * 数组模拟单链表
 */
public class StaticLinkedListTemp{
    // 存储链表节点的值
    int[] e;
    // 存储链表下一个节点的下标
    int[] ne;
    // 当前指向的链表下标(已经用到了哪个下标)
    int idx;
    // 头节点指向
    int head;

    /**
     * 初始化
     * @param l
     */
    StaticLinkedListTemp(int l){
        this.e = new int[l];
        this.ne = new int[l];
        head = -1;
    }
    /**
     * 将值x添加到头节点
     * @param x
     */
    public void addToHead(int x){
        ne[idx] = head;
        head = idx;
        e[idx] = x;
        idx++;
    }

    /**
     * 在k后面的节点添加x
     * @param k 节点下标
     * @param x
     */
    public void add(int k, int x){
        ne[idx] = ne[k];
        e[idx] = x;
        ne[k] = idx;
        idx++;
    }

    /**
     * 删除k后面的一个节点
     * @param k 节点下标
     */
    public void delete(int k){
        ne[k] = ne[ne[k]];
    }
}

/**
 * 数组模拟双链表
 */
class StaticLinkedListTemp2{
    int[] e;
    int[] l;
    int[] r;
    int idx;

    StaticLinkedListTemp2(int l){
        this.e = new int[l];
        this.l = new int[l];
        this.r = new int[l];
    }

    /**
     * 在k右边添加一个数
     * @param k
     * @param x
     */
    void add(int k, int x){
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    /**
     * 删除k
     * @param k
     */
    void remove(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}