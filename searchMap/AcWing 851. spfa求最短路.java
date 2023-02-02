package searchMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目描述
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 * 
 * 请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 impossible。
 * 
 * 数据保证不存在负权回路。
 * 
 * 样例
 * 输入样例：
3 3
1 2 5
2 3 -3
1 3 4
 * 输出样例：
 * 2
 * 
 */
class AcWing851 {
    static final int N = 100010;
    static int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    static int idx = 0;
    static int[] dist = new int[N];
    static int n;
    static int m;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = br.read() - '0';
            br.skip(1);
            m = br.read() - '0';
            br.skip(1);
            Arrays.fill(h, -1);
            for (int i = 0; i < m; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
                add(line[0],line[1],line[2]);
            }
            spfa();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static void add(int i, int j, int k) {
        e[idx] = j;
        w[idx] = k;
        ne[idx] = h[i];
        h[i] = idx++;
    }

    static void spfa() {
        Arrays.fill(dist, Integer.MAX_VALUE >> 1);
        Deque<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        while(!q.isEmpty()){
            int t = q.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                int wi = w[i];
                if (dist[j] > dist[t] + wi) {
                    dist[j] = dist[t] + wi;
                    if (!q.contains(j)) q.offer(j);
                }
            }
        }
        System.out.println(dist[n] > Integer.MAX_VALUE >> 2?"impossible":dist[n]);
    }
}
