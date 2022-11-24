package searchMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 树的重心
给定一颗树，树中包含n个结点（编号1~n）和n-1条无向边。

请你找到树的重心，并输出将重心删除后，剩余各个连通块中点数的最大值。

重心定义：重心是指树中的一个结点，如果将这个点删除后，剩余各个连通块中点数的最大值最小，那么这个节点被称为树的重心。

输入格式
第一行包含整数n，表示树的结点数。

接下来n-1行，每行包含两个整数a和b，表示点a和点b之前存在一条边。

输出格式
输出一个整数m，表示重心的所有的子树中最大的子树的结点数目。

数据范围
1≤n≤1051≤n≤105
输入样例
9
1 2
1 7
1 4
2 8
2 5
4 3
3 9
4 6
输出样例：
4

 */
class Acwing846 {
    static final int N = 10010;
    static final int[] h = new int[N], e = new int[N], ne = new int[N];
    static final boolean[] stu = new boolean[N];
    static int idx = 0;
    static int ans = N;
    static int m = 0;

    public static void main(String[] args) {
        Arrays.fill(h, -1);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            m = Integer.valueOf(br.readLine());
            for (int i = 0; i < m-1; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.valueOf(line[0]);
                int b = Integer.valueOf(line[1]);
                add(a, b);
                add(b, a);
            }
            dfs(1);
            System.out.println(ans);
        }catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 返回包含u的子树
    static int dfs(int u){
        stu[u] = true;
        // num 当前子树节点数，从1开始。
        // res 去掉当前节点对应后对应的最大子数的数目
        int num = 1, res = 0;
        // 遍历指向的节点
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!stu[j]) {
                // 返回u的子树的节点数 并找到最大
                int s = dfs(j);
                res = Math.max(res, s);
                // 计算子树节点和
                num += s;
            }
        }
        // 取最大子树
        res = Math.max(res, m - num);
        // 取所有最大子树的最小值
        ans = Math.min(ans, res);
        // 返回当前包含u的子树节点数
        return num;
    }

    // 添加 图的边
    static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }
}
