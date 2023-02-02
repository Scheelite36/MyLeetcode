package searchMap;

import java.util.Arrays;

/**
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * 
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi -
 * yj| ，其中 |val| 表示 val 的绝对值。
 * 
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * 
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 */
class Solution1584 {
    final int INF = Integer.MAX_VALUE;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] x = points[i];
                int[] y = points[j];
                int c = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
                map[i][j] = map[j][i] = Math.min(map[i][j], c);
            }
        }
        return prime(map);
    }

    int prime(int[][] map) {
        int n = map.length;
        boolean[] st = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;
            }
            if (i != 0)
                res += dist[t];
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], map[t][j]);
            }
            st[t] = true;
        }
        return res;

    }
}
