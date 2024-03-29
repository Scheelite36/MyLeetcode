package searchMap;

import java.util.Scanner;

/**
 * 题目描述
 * n−皇后问题是指将 n 个皇后放在 n×n 的国际象棋棋盘上，使得皇后不能相互攻击到，即任意两个皇后都不能处于同一行、同一列或同一斜线上。
 * 
 * 
 * 
 * 现在给定整数 n，请你输出所有的满足条件的棋子摆法。
 * 
 * 输入格式
 * 共一行，包含整数 n。
 * 
 * 输出格式
 * 每个解决方案占 n 行，每行输出一个长度为 n 的字符串，用来表示完整的棋盘状态。
 * 
 * 其中 . 表示某一个位置的方格状态为空，Q 表示某一个位置的方格上摆着皇后。
 * 
 * 每个方案输出完成后，输出一个空行。
 * 
 * 注意：行末不能有多余空格。
 * 
 * 输出方案的顺序任意，只要不重复且没有遗漏即可。
 * 
 * 数据范围
 * 1≤n≤9
 * 
 * 样例
 * 输入样例：
 * 4
 * 输出样例：
 * .Q..
 * ...Q
 * Q...
 * ..Q.
 * 
 * ..Q.
 * Q...
 * ...Q
 * .Q..
 * 
 * 作者：狛枝
 * 链接：https://www.acwing.com/file_system/file/content/whole/index/content/3030588/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing843 {
    static final int N = 20;
    // 分别存储竖向 斜向 反斜向 是否存在Q
    static final boolean[] col = new boolean[N],
            dg = new boolean[N], udg = new boolean[N];
    static final char[][] matrix = new char[N][N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        dfs(0);
    }

    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        // 每列进行计算
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[u - i + n]) {
                matrix[u][i] = 'Q';
                col[i] = dg[u + i] = udg[u - i + n] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[u - i + n] = false;
                matrix[u][i] = '.';
            }
        }
    }
}
