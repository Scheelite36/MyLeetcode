package merge;

import java.util.Scanner;

/**
 * 动物王国中有三类动物 A,B,C，这三类动物的食物链构成了有趣的环形。

A 吃 B，B 吃 C，C 吃 A。

现有 N 个动物，以 1∼N 编号。

每个动物都是 A,B,C 中的一种，但是我们并不知道它到底是哪一种。

有人用两种说法对这 N 个动物所构成的食物链关系进行描述：

第一种说法是 1 X Y，表示 X 和 Y 是同类。

第二种说法是 2 X Y，表示 X 吃 Y。

此人对 N 个动物，用上述两种说法，一句接一句地说出 K 句话，这 K 句话有的是真的，有的是假的。

当一句话满足下列三条之一时，这句话就是假话，否则就是真话。

当前的话与前面的某些真的话冲突，就是假话；
当前的话中 X 或 Y 比 N 大，就是假话；
当前的话表示 X 吃 X，就是假话。
你的任务是根据给定的 N 和 K 句话，输出假话的总数。

输入格式
第一行是两个整数 N 和 K，以一个空格分隔。

以下 K 行每行是三个正整数 D，X，Y，两数之间用一个空格隔开，其中 D 表示说法的种类。

若 D=1，则表示 X 和 Y 是同类。

若 D=2，则表示 X 吃 Y。

输出格式
只有一个整数，表示假话的数目。

数据范围
1≤N≤50000,
0≤K≤100000
输入样例：
100 7
1 101 1 
2 1 2
2 2 3 
2 3 3 
1 1 3 
2 3 1 
1 5 5
输出样例：
3
 */
class AcWing240 {
    static final int N = 50000;
    static int[] p = new int[N];
    static int[] d = new int[N];
    static int res;
    static{
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
    }
    static int find(int x){
        if(p[x] != x) {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        while(n-- > 0){
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x > m || y > m) res++;
            int px = find(x);
            int py = find(y);
            if (op == 1){
                if (px == py && (d[y]-d[x]) % 3 != 0) res++;
                else if (px != py) {
                    // 合并集合
                    p[px] = py;
                    // 使得 d[y]-d[x] 依然是3的倍数 同类
                    d[p[x]] = d[y]- d[x];
                }
            }else{
                if (px == py && (d[x]-d[y]-1) % 3 != 0) res++;
                else if (px != py) {
                    p[px] = py;
                    d[px] = d[y] - d[x] +1;
                }
            }
        }
        System.out.println(res);
    }
}
