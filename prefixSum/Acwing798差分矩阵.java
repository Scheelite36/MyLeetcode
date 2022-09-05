package prefixSum;

import java.util.Scanner;

/**
 * 输入一个 n 行 m 列的整数矩阵，再输入 q 个操作，每个操作包含五个整数 x1,y1,x2,y2,c，其中 (x1,y1) 和 (x2,y2)
 * 表示一个子矩阵的左上角坐标和右下角坐标。
 * 
 * 每个操作都要将选中的子矩阵中的每个元素的值加上 c。
 * 
 * 请你将进行完所有操作后的矩阵输出。
 * 
 * 输入格式
 * 第一行包含整数 n,m,q。
 * 
 * 接下来 n 行，每行包含 m 个整数，表示整数矩阵。
 * 
 * 接下来 q 行，每行包含 5 个整数 x1,y1,x2,y2,c，表示一个操作。
 * 
 * 输出格式
 * 共 n 行，每行 m 个整数，表示所有操作进行完毕后的最终矩阵。
 * 
 * 数据范围
 * 1≤n,m≤1000,
 * 1≤q≤100000,
 * 1≤x1≤x2≤n,
 * 1≤y1≤y2≤m,
 * −1000≤c≤1000,
 * −1000≤矩阵内元素的值≤1000
 * 输入样例：
 * 3 4 3
 * 1 2 2 1
 * 3 2 2 1
 * 1 1 1 1
 * 1 1 2 2 1
 * 1 3 2 3 2
 * 3 1 3 4 1
 * 输出样例：
 * 2 3 4 1
 * 4 3 4 1
 * 2 2 2 2
 */
class Acwing798 {
    int[][] s;

    void insert(int x1, int y1, int x2, int y2, int c) {
        s[x1][y1] += c;
        s[x2 + 1][y1] -= c;
        s[x1][y2 + 1] -= c;
        s[x2 + 1][y2 + 1] += c;
    }

    public static void main(String[] args) {
        Acwing798 ac = new Acwing798();
        Scanner sc = new Scanner(System.in);
        int l, m, n;
        l = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();
        ac.s = new int[l + 2][m + 2];
        int[][] a = new int[l + 1][m + 1];
        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // 构造差分数组
        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                ac.insert(i, j, i, j, a[i][j]);
            }
        }
        while(n-->0){
            ac.insert(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        for (int i = 1; i < l+1; i++) {
            for (int j = 1; j < m+1; j++) {
                ac.s[i][j] += (ac.s[i-1][j]+ac.s[i][j-1]-ac.s[i-1][j-1]);
            }
        }
        for (int i = 1; i < l+1; i++) {
            for (int j = 1; j < m+1; j++) {
                System.out.print(ac.s[i][j]+" ");
            }
            System.out.println();
        }
    }
}
