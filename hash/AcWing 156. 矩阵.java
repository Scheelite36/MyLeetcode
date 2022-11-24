package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个 M 行 N 列的 01 矩阵（只包含数字 0 或 1 的矩阵），再执行 Q 次询问，每次询问给出一个 A 行 B 列的 01
 * 矩阵，求该矩阵是否在原矩阵中出现过。
 * 
 * 输入格式
 * 第一行四个整数 M,N,A,B。
 * 
 * 接下来一个 M 行 N 列的 01 矩阵，数字之间没有空格。
 * 
 * 接下来一个整数 Q。
 * 
 * 接下来 Q 个 A 行 B 列的 01 矩阵，数字之间没有空格。
 * 
 * 输出格式
 * 对于每个询问，输出 1 表示出现过，0 表示没有出现过。
 * 
 * 数据范围
 * A≤100，M,N,B≤1000，Q≤1000
 * 输入样例：
 * 3 3 2 2
 * 111
 * 000
 * 111
 * 3
 * 11
 * 00
 * 11
 * 11
 * 00
 * 11
 * 输出样例：
 * 1
 * 0
 * 1
 */
class AcWing156 {
    static final int N = 1010;
    static final int M = N * N;
    static final int P = 131;
    static final long[] p = new long[M];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int m = Integer.valueOf(f[0]), n = Integer.valueOf(f[1]);
        int a = Integer.valueOf(f[2]), b = Integer.valueOf(f[3]);
        long[][] h = new long[N][N];
        p[0] = 1;
        // 初始化p
        for (int i = 1; i <= n * m; i++) {
            p[i] = p[i - 1] * P;
        }
        // 初始化h 以行为单位计算hash
        for (int i = 1; i <= m; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                h[i][j] = h[i][j - 1] * P + s.charAt(j - 1) - '0';
            }
        }
        Set<Long> set = new HashSet<>();
        // 逐列 再逐行 计算hash
        for (int j = b; j <= n; j++) {
            int l = j - b + 1, r = j;
            long s = 0;
            for (int i = 1; i <= m; i++) {
                s = s * p[b] + getLineHash(h[i], l, r);
                // 超出就减去第一行
                if (i > a)
                    s -= getLineHash(h[i - a], l, r) * p[a * b];
                // 到了子矩阵最后一行 保存该位置的hash
                if (i >= a)
                    set.add(s);
            }
        }
        int count = Integer.valueOf(br.readLine());
        // 计算待匹配的矩阵
        while (count-- > 0) {
            long s = 0;
            for (int i = 0; i < a; i++) {
                String st = br.readLine();
                for (int j = 0; j < b; j++) {
                    s = s * P + st.charAt(j) - '0';
                }
            }
            if (set.contains(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
        br.close();
    }

    // 获取某一行的部分hash 依然是从1开始的索引
    static long getLineHash(long[] h, int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
