package searchMap;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution2203 {

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<int[]>[] g= new ArrayList[n], rg = new ArrayList[n];
        long[] dist1 = new long[n], dist2 = new long[n], dist3 = new long[n];
        long min = Long.MAX_VALUE >> 2;
        Arrays.setAll(g, e->new ArrayList<>());
        Arrays.setAll(rg, e->new ArrayList<>());
        for (int[] is : edges) {
            g[is[0]].add(new int[]{is[1], is[2]});
            rg[is[1]].add(new int[]{is[0], is[2]});
        }

        dijstra(dest,rg, dist1);
        dijstra(src1, g, dist2);
        dijstra(src2,g, dist3);
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dist1[i]+dist2[i]+dist3[i]);
        }
        return min >= Long.MAX_VALUE >> 2 ? -1 : min;
    }

    void dijstra(int s,List<int[]>[] g, long[] dist) {
        Arrays.fill(dist, Long.MAX_VALUE >> 2);
        dist[s] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>((o1, o2) -> (Long.compare(o1[0],o2[0])));
        q.offer(new long[] { 0, s });
        while (!q.isEmpty()) {
            long[] t = q.poll();
            for (int[] i : g[(int)t[1]]) {
                int j = i[0];
                int w = i[1];
                if(dist[j] > (long)t[0] + w){
                    dist[j] = (long)t[0] + w;
                    q.offer(new long[]{dist[j],j});
                }
            }
        }
    }

    public static void main(String[] args) {
        // 6
        // [[0,2,2],[0,5,6],[1,0,3],[1,4,5],[2,1,1],[2,3,3],[2,3,4],[3,4,2],[4,5,1]]
        Solution2203 s = new Solution2203();
        s.minimumWeight(6, new int[][] { { 0, 2, 2 }, { 0, 5, 6 }, { 1, 0, 3 }, { 1, 4, 5 }, { 2, 1, 1 }, { 2, 3, 3 },
                { 2, 3, 4 }, { 3, 4, 2 }, { 4, 5, 1 } }, 0, 1, 5);
    }
}
