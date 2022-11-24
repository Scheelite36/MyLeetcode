package searchMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述
给定一个 nn 个点 mm 条边的有向图，点的编号是 11 到 nn，图中可能存在重边和自环。

请输出任意一个该有向图的拓扑序列，如果拓扑序列不存在，则输出 −1−1。

若一个由图中所有点构成的序列 AA 满足：对于图中的每条边 (x,y)(x,y)，xx 在 AA 中都出现在 yy 之前，则称 AA 是该图的一个拓扑序列。

输入格式
第一行包含两个整数 nn 和 mm。

接下来 mm 行，每行包含两个整数 xx 和 yy，表示存在一条从点 xx 到点 yy 的有向边 (x,y)(x,y)。

输出格式
共一行，如果存在拓扑序列，则输出任意一个合法的拓扑序列即可。

否则输出 −1。

数据范围
1≤n,m≤1051≤n,m≤105
样例
输入样例：
3 3
1 2
2 3
1 3
输出样例：
1 2 3
 */
class Acwing848 {
    static final int N = 100010;
    static final int[] e = new int[N], ne = new int[N],
    h = new int[N], d = new int[N];
    static int idx = 0;
    static int n = 0;
    static List<Integer> l = new ArrayList<>();
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int m = br.read()-'0';
            br.skip(1);
            n = br.read()-'0';
            br.skip(1);
            Arrays.fill(h, -1);
            while(m -- > 0){
                int a = br.read()-'0';
                br.skip(1);
                int b = br.read()-'0';
                br.skip(1);
                add(a, b);
                // b的入度+1
                d[b]++;
            }
            if (bfs()){
                for (int i : l) {
                    System.out.print(i + " ");
                }
            }
            else System.out.println("-1");
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
    static boolean bfs(){
        Deque<Integer> q = new LinkedList<>();
        // 将入度为0的点收集起来
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int o = q.poll();
            l.add(o);
            for (int i = h[o]; i != -1; i = ne[i]) {
                int j = e[i];
                // j的度减去1 就是把 ij连线去掉
                if (-- d[j] == 0) q.offer(j);
            }
        }
        return l.size() == n;
    }
    
    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
