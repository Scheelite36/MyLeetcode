package merge;

/**
 * 1. 朴素并查集
 */
public class mergeTemp {
    // 存储节点对应的根节点
    static int[] p;
    // 初始化根节点 假定对应每个节点先各自独立
    static {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
    }
    // 查找根节点
    int find(int x){
        if (p[x] != x) p[x] = find(x);
        return p[x];
    }
    // 合并a b所在的集合
    void merge(int a, int b){
        p[find(a)] = find(b);
    }
    
}
/**
 * 2. 维护数量的并查集
 * 相较于第一种多维护了一个size集合
 */
class mergeTemp2{
    static int[] p;
    static int[] size;
    static {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }
    // 查找根节点
    int find(int x){
        if (p[x] != x) p[x] = find(x);
        return p[x];
    }
    // 合并a b所在的集合
    void merge(int a, int b){
        if (find(a) == find(b)) return;
        p[find(a)] = find(b);
        size[find(a)] += size[find(b)];
    }
}
/*
 * 维护到祖宗节点的距离
 */
class mergeTemp3{
    static int[] p;
    // 到根节点的距离
    static int[] d;

    // 查找根节点 优化路径的时候同时维护距离
    static int find(int x){
        if(p[x] != x) {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }

    void merge(int x, int y){
        //省略
        // 合并集合
        p[find(x)] = find(y);
        // 维护根节点距离的逻辑
        d[p[x]] = d[y]- d[x];
    }
}
