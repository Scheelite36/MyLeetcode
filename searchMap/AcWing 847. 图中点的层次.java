package searchMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目描述
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环。
 * 
 * 所有边的长度都是 1，点的编号为 1∼n。
 * 
 * 请你求出 1 号点到 n 号点的最短距离，如果从 1 号点无法走到 n 号点，输出 −1。
 * 
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 * 
 * 接下来 m 行，每行包含两个整数 a 和 b，表示存在一条从 a 走到 b 的长度为 1 的边。
 * 
 * 输出格式
 * 输出一个整数，表示 1 号点到 n 号点的最短距离。
 * 
 * 数据范围
 * 1≤n,m≤105
 * 样例
4 5
1 2
2 3
3 4
1 3
1 4
 */
class AcWing847 {
    static final int N = 100010;
    static final int[] h = new int[N], e = new int[N],
            ne = new int[N], visited = new int[N];
    static int idx = 0;
    static int n = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Arrays.fill(h, -1);
            n = br.read() - '0';
            br.skip(1);
            int m = br.read() - '0';
            br.skip(1);
            while (m-- > 0) {
                int a = br.read() - '0';
                br.skip(1);
                int b = br.read() - '0';
                br.skip(1);
                add(a,b);
            }

            Arrays.fill(visited, -1);
            System.out.println(bfs());
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    static int bfs(){
        Deque<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 0;
        while(!q.isEmpty()){
            int k = q.poll();
            for (int i = h[k]; i != -1; i = ne[i]) {
                int j = e[i];
                if (visited[j] == -1){
                    visited[j] = visited[k] +1;
                    q.offer(j);
                }
            }
        }
        return visited[n];
    }
    static void add(int a, int b){
        e[idx] = b; 
        ne[idx] = h[a];
        h[a] = idx++;
    } 
}
