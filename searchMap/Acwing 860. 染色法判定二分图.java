package searchMap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个n个点m条边的无向图，图中可能存在重边和自环。
 * 
 * 请你判断这个图是否是二分图。
 * 
 * 输入格式
 * 第一行包含两个整数n和m。
 * 
 * 接下来m行，每行包含两个整数u和v，表示点u和点v之间存在一条边。
 * 
 * 输出格式
 * 如果给定图是二分图，则输出“Yes”，否则输出“No”。
 * 
 * 数据范围
 * 1≤ n,m≤ 105
 * 
 * 输入样例：
4 4
1 3
1 4
2 3
2 4
 * 
 * 输出样例：
 * Yes
 */
class Acwing860 {
    static final int N = 100010;
    static int[] h = new int[N], e = new int[2 * N], ne = new int[2 * N];
    static int idx = 0;
    static Integer[] color = new Integer[N];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int n = line[0];
            int m = line[1];
            Arrays.fill(h, -1);
            while (m-- > 0) {
                add(line[0], line[1]);
                add(line[1], line[0]);
            }
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                // 改点没有被染过色的话就判断dfs进行染色并判断是否产生矛盾
                if (color[i] == null) {
                    if (!dfs(i, 0)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                System.out.println("Yes");
            else
                System.out.println("No");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean dfs(int i, int c) {
        color[i] = c;
        for (int j = h[i]; j != -1; j = ne[j]) {
            int v = e[j];
            if (color[v] == null) {
                if (!dfs(j, ~c))
                    return false;
            } else if (color[v] != ~c)
            // 已经染色节点与 需要染的颜色 相矛盾
                return false;
        }
        return true;
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

}
