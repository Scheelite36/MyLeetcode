package searchMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述
 * 给定一个n个点m条边的无向图，图中可能存在重边和自环，边权可能为负数。
 * 
 * 求最小生成树的树边权重之和，如果最小生成树不存在则输出impossible。
 * 
 * 给定一张边带权的无向图G=(V, E)，其中V表示图中点的集合，E表示图中边的集合，n=|V|，m=|E|。
 * 
 * 由V中的全部n个顶点和E中n-1条边构成的无向连通子图被称为G的一棵生成树，其中边的权值之和最小的生成树被称为无向图G的最小生成树。
 * 
 * 输入格式
 * 第一行包含两个整数n和m。
 * 
 * 接下来m行，每行包含三个整数u，v，w，表示点u和点v之间存在一条权值为w的边。
 * 
 * 输出格式
 * 共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出impossible。
 * 
 * 数据范围
 * 1≤n≤105,
 * 1≤m≤2∗10^5,
 * 图中涉及边的边权的绝对值均不超过1000。
 * 
 * 输入样例：
4 5
1 2 1
1 3 2
1 4 3
2 3 2
3 4 4
 * 输出样例：
 * 6
 * 
 * 作者：空_22
 * 链接：https://www.acwing.com/solution/content/34242/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Acwing859 {
    static final int N = 100010;
    static int[] p = new int[N];
    static int[][] sides;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = br.read() - '0';
            br.skip(1);
            int m = br.read() - '0';
            br.skip(1);
            sides = new int[m][3];
            for (int i = 0; i < m; i++) {
                sides[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            }
            Arrays.sort(sides, (o1, o2) -> o1[2] - o2[2]);
            for (int i = 1; i <= n; i++) {
                p[i] = i;
            }
            int res = 0;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                int a = find(sides[i][0]);
                int b = find(sides[i][1]);
                int c = sides[i][2];
                if (a != b) {
                    p[a] = b;
                    res += c;
                    cnt++;
                }
            }
            if (cnt < n-1) System.out.println("impossible");
            else System.out.println(res);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }
}
