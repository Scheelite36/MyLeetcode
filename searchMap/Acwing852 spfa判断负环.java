package searchMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目描述
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 * 
 * 请你判断图中是否存在负权回路。
 * 
 * 输入格式
 * 第一行包含整数n和m。
 * 
 * 接下来m行每行包含三个整数x，y，z，表示点x和点y之间存在一条有向边，边长为z。
 * 
 * 输出格式
 * 如果图中存在负权回路，则输出“Yes”，否则输出“No”。
 * 
 * 数据范围
 * 1≤n≤2000,
 * 1≤m≤10000,
 * 图中涉及边长绝对值均不超过10000。
 * 
 * 样例
 * 输入样例：
3 3
1 2 -1
2 3 4
3 1 -4
 * 输出样例：
 * Yes
 */
class Acwing852 {
    static final int N = 10010;
    static int[] h = new int[N], e = new int[N], ne = new int[N],
     w = new int[N], dist = new int[N], cnt = new int[N];
    static int idx = 0;
    static int n;
    static int m;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = br.read() - '0';
            br.skip(1);
            m = br.read() - '0';
            br.skip(1);
            Arrays.fill(h, -1);
            while (m-- > 0) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
                add(line[0], line[1], line[2]);
            }
            System.out.println(spfa()? "Yes":"No");
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    static boolean spfa() {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while(!q.isEmpty()) {
           int t = q.poll();
           for (int i = h[t]; i != -1; i=ne[i]) {
                int j = e[i];
                int wi = w[i];
                if (dist[j] > dist[t] + wi){
                    dist[j]= dist[t]+ wi;
                    cnt[j] = cnt[t] +1;
                    if (cnt[j] >= n) return true;
                    if (!q.contains(j)){
                        q.offer(j); 
                    } 
                }
           }
        }
        return false;
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
