package searchMap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个n 个点m条边的有向图，可能存在重边和自环，无负权边。求1号点到n号点的最短距离。如果不存在路径，则输出−1。
 * 
 * 输入格式：
 * 第一行包含整数n和m。接下来m行每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z
 * 
 * 输出格式：
 * 输出一个整数，表示1号点到n号点的最短距离。如果路径不存在，则输出−1。
 * 
 * 数据范围：
 * 1 ≤ n ≤ 500
 * 1 ≤ m ≤ 10^5
 * e ≤ 10000
 * e为边长
 * 
 * 输入样例
3 3
1 2 2
2 3 1
1 3 4
 * 输出
 * 3
 */
class Acwing849 {
    static final int N = 10010;
    // 存储图
    static int[][] map = new int[N][N];
    // 已经确定了最短距离的点
    static boolean[] pinned = new boolean[N];
    // 存储最短距离
    static int[] dist = new int[N];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = br.read() - '0';
            br.skip(1);
            int m = br.read() - '0';
            br.skip(1);
            // 因为是稠密图 采用邻接矩阵存储
            while (m-- > 0) {
                int i = br.read() - '0';
                br.skip(1);
                int j = br.read() - '0';
                br.skip(1);
                map[i][j] = br.read() - '0';
                br.skip(1);
            }
            System.out.println(dijkstra(n));
        } catch (Exception e) {

        }
    }

    static int dijkstra(int n) {
        // 初始化距离
        Arrays.fill(dist, N);
        dist[1] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            // 寻找到不在s中（dist为false）的最短路距离
            for (int j = 1; j <= n; j++) {
                if (!pinned[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            pinned[t] = true;
            // 用t去更新剩下的点
            for (int j = 1; j <= n; j++) {
                // 更新j到1的距离 多个距离取最短距离
                dist[j] = Math.min(map[t][j] + dist[t], dist[j]);
            }
        }
        return dist[n] == N ? -1 : dist[n];
    }
}
