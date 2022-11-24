package searchMap;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 有 n 个网络节点，标记为 1 到 n。
 * 
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点，
 * wi 是一个信号从源节点传递到目标节点的时间。
 * 
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 * 示例 1：
 * 
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 * 
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 * 
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *  
 * 
 * 提示：
 * 
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution743 {
    static final int N = 6010;
    int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N], dist = new int[N];
    int idx = 0;

    public int networkDelayTime(int[][] times, int n, int k) {
        Arrays.fill(h, -1);
        for (int[] is : times) {
            add(is[0], is[1], is[2]);
        }
        return spfa(k, n);
    }

    int spfa(int k, int n) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> q = new LinkedList<>();
        q.offer(k);
        dist[k] = 0;
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!q.contains(j)) {
                        q.offer(j);
                    }
                }
            }
        }
        int max = 0;
        for (int i=1;i<=n;i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            else max = Math.max(max, dist[i]);
        }
        return max;
    }

    void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
