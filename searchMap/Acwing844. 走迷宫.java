package searchMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个n*m的二维整数数组，用来表示一个迷宫，数组中只包含0或1，其中0表示可以走的路，1表示不可通过的墙壁。

最初，有一个人位于左上角(1, 1)处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。

请问，该人从左上角移动至右下角(n, m)处，至少需要移动多少次。

数据保证(1, 1)处和(n, m)处的数字为0，且一定至少存在一条通路。

输入格式

第一行包含两个整数n和m。

接下来n行，每行包含m个整数（0或1），表示完整的二维数组迷宫。

输出格式

输出一个整数，表示从左上角移动至右下角的最少移动次数。

数据范围

1≤n,m≤100

样例
输入样例：
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
输出样例：
8


作者：白马金羁侠少年
链接：https://www.acwing.com/solution/content/2078/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Acwing844 {
    static final int N = 100;
    // 保存迷宫
    static boolean[][] dg = new boolean[N][N];
    // 保存移动次数
    static int[][] move = new int[N][N];
    // 方向
    static final int[][] diret = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.valueOf(s[0]), n = Integer.valueOf(s[1]);
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                dg[i][j] = line[j].equals("0") ? true: false;
            }
        }
        br.close();
        System.out.println(bfs(m, n));
    }


    static int bfs(int m, int n){
        Deque<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        while (!q.isEmpty()){
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p[0]+diret[i][0], y = p[1]+diret[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && dg[x][y] && move[x][y] == 0){
                    move[x][y] = move[p[0]][p[1]] + 1;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return move[m-1][n-1];
    }
}
