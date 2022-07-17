package trackBack;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 * 
 * 
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * 
 * 
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 * 
 * 
 * 数据范围： 2 \le n,m \le 10 \2≤n,m≤10 ， 输入的内容只包含 0 \le val \le 1 \0≤val≤1
 * 
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * 
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 * 
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 * 
 * 
 * 回溯解法
 */
class Main3 {
    public static int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    public static int m = 0;
    public static int n = 0;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        boolean[][] road = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                road[i][j] = in.nextInt() == 0 ? true : false;
            }
        }
        boolean[][] isVisited = new boolean[m][n];
        List<int[]> res = new ArrayList<>();
        res.add(new int[] { 0, 0 });
        isVisited[0][0] = true;
        traceBack(res, road, isVisited, 0, 0);
    }

    public static void traceBack(List<int[]> res, boolean[][] road,
            boolean[][] isVisited, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            printRes(res);
            return;
        }
        for (int[] dir : direction) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI < 0 || newI > m - 1 || newJ < 0 || newJ > n - 1 || !road[newI][newJ] || isVisited[newI][newJ]) {
                continue;
            }
            isVisited[newI][newJ] = true;
            int[] pos = new int[] { newI, newJ };
            res.add(pos);
            traceBack(res, road, isVisited, newI, newJ);
            res.remove(pos);
            isVisited[newI][newJ] = false;
        }
    }

    public static void printRes(List<int[]> res) {
        for (int[] points : res) {
            System.out.println("(" + points[0] + "," + points[1] + ")");
        }
    }
}
