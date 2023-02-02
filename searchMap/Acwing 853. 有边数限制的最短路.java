package searchMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 * 
 * 请你求出从 1 号点到 n 号点的最多经过 k 条边的最短距离，如果无法从 1 号点走到 n 号点，输出 impossible。
 * 
 * 注意：图中可能 存在负权回路 。
 * 
 * 输入格式
 * 第一行包含三个整数 n,m,k。
 * 
 * 接下来 m 行，每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。
 * 
 * 点的编号为 1∼n。
 * 
 * 输出格式
 * 输出一个整数，表示从 1 号点到 n 号点的最多经过 k 条边的最短距离。
 * 
 * 如果不存在满足条件的路径，则输出 impossible。
 * 
 * 数据范围
 * 1≤n,k≤500,
 * 1≤m≤10000,
 * 1≤x,y≤n，
 * 任意边长的绝对值不超过 10000。
 * 
 * 输入样例：
3 3 1
1 2 1
2 3 1
1 3 3
 * 输出样例：
 * 3
 */
class Acwing853 {
    static final int N = 10000;
    static int[][] line = new int[N][3];
    static int[] dist;
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = br.read() - '0';
            br.skip(1);
            m = br.read() - '0';
            br.skip(1);
            int k = br.read() - '0';
            br.skip(1);
            dist = new int[n+1];
            for (int i = 1; i <= m; i++) {
                line[i][0] = br.read() - '0';
                br.skip(1);
                line[i][1] = br.read() - '0';
                br.skip(1);
                line[i][2] = br.read() - '0';
                br.skip(1);
            }
            System.out.println(bellmanFord(k));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    static int bellmanFord(int k) {
        Arrays.fill(dist, Integer.MAX_VALUE >> 1);
        dist[1] = 0;
        for (int i = 1; i <= k; i++) {
            int[] backup = Arrays.copyOf(dist, n);
            for (int j = 1; j <= m; j++) {
                int[] l = line[j];
                if (dist[l[1]] > backup[l[0]] + l[2]) {
                    dist[l[1]] = backup[l[0]] + l[2];
                }
            }
        }
        return dist[n] > Integer.MAX_VALUE >> 2 ? -1 : dist[n];
    }
}