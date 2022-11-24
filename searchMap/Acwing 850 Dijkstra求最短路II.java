package searchMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
给定一个 nn 个点 mm 条边的有向图，图中可能存在重边和自环，所有边权均为非负值。

请你求出 11 号点到 nn 号点的最短距离，如果无法从 11 号点走到 nn 号点，则输出 −1−1。

输入格式
第一行包含整数 nn 和 mm 。

接下来 mm 行每行包含三个整数 x,y,zx,y,z，表示存在一条从点 xx 到点 yy 的有向边，边长为 zz。

输出格式
输出一个整数，表示 11 号点到 nn 号点的最短距离。

如果路径不存在，则输出 −1−1。

数据范围
1≤n,m≤1.5∗10^5,
图中涉及边长均不超过10000。
图中涉及边长均不小于 0，且不超过 10000。
数据保证：如果最短路存在，则最短路的长度不超过 10^9。

输入样例：
3 3
1 2 2
2 3 1
1 3 4
输出样例：
3
 */
class Acwing850 {
    static final int N = 100010;
    static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    static int idx = 0;
    static boolean[] pinned = new boolean[N];
    static int[] dist = new int[N];


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Arrays.fill(h, -1);

            int n = br.read() - '0';
            br.skip(1);
            int m = br.read()  - '0';
            br.skip(1);
            
            while(m-- > 0){
                int a = br.read()-'0';
                br.skip(1);
                int b = br.read()-'0';
                br.skip(1);
                int c =br.read()-'0';
                br.skip(1);
                add(a, b, c);
            }
            
            System.out.println(dijkstra(n));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    static int dijkstra(int n) {
        final int L = 10010;
        // 初始化
        Arrays.fill(dist, L);
        dist[1] = 0;
        // 优先队列保存 每次去处距离最小的点
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 1));
        
        while (!q.isEmpty()) {
            Point t = q.poll();
            if (pinned[t.n]) continue;
            pinned[t.n] = true;
            for (int i = h[t.n]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > t.dist + w[j]){
                    dist[j] = t.dist + w[i];
                    q.add(new Point(dist[j], j));
                }
            }
        }
        return dist[n] == L ? -1 : dist[n];
    }

    static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
        
    }

    static class Point implements Comparable<Point> {
        int dist;
        int n;

        public Point(int dist, int n){
            this.dist = dist;
            this.n = n;
        }
        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }
}
