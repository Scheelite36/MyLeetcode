package searchMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.validation.Validator;

/**
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi,
 * weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST)
 * 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 * 
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 * 
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 * 
 * 示例 1：
 * 
 * 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 输出：[[0,1],[2,3,4,5]]
 * 解释：上图描述了给定图。
 * 下图是所有的最小生成树。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1489 {
    int[] p;
    int amount;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        p = new int[n];
        amount = n;
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int[] nis = Arrays.copyOf(edges[i], 4);
            nis[3] = i;
            edges[i] = nis;
        }
        Arrays.sort(edges, (o1,o2)->(o1[2]-o2[2]));
        initP();
        int o = kruskal(edges);
        List<Integer> t = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            initP();
            int oo = kruskal(edges, i, 0);
            if (oo ==-1 || o < oo) t.add(edges[i][3]);
            else {
                initP();
                p[edges[i][0]] = edges[i][1];
                int ll = kruskal(edges, i, 1);
                if (ll+edges[i][2] == oo) f.add(edges[i][3]);
            } 
        }
        return Stream.of(t, f).collect(Collectors.toList());
    }

    void initP(){
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
    }
    
    int kruskal(int[][] e){
        int res = 0, cnt = 0;
        for (int i = 0; i < e.length; i++) {
            int a= find(e[i][0]);
            int b= find(e[i][1]);
            int c= e[i][2];
            if (a!=b){
                p[a] = b;
                res+=c;
                cnt++;
            }
        }
        return cnt<amount-1?-1:res;
    }

    int kruskal(int[][] e, int r, int cnt){
        int res = 0;
        for (int i = 0; i < e.length; i++) {
            if (i == r) continue;
            int a= find(e[i][0]);
            int b= find(e[i][1]);
            int c= e[i][2];
            if (a!=b){
                p[a] = b;
                res+=c;
                cnt++;
            }
        }
        return cnt<amount-1?-1:res;
    }

    int find(int a){
        if (a != p[a]) p[a] = find(p[a]);
        return p[a];
    }
    public static void main(String[] args) {
        Solution1489 s = new Solution1489();
        s.findCriticalAndPseudoCriticalEdges(6, new int[][] {{0,1,1},{1,2,1},{0,2,1},{2,3,4},{3,4,2},{3,5,2},{4,5,2}});
    }
}