package stack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。
 * 
 * 输入格式
 * 第一行包含整数 N，表示数列长度。
 * 
 * 第二行包含 N 个整数，表示整数数列。
 * 
 * 输出格式
 * 共一行，包含 N 个整数，其中第 i 个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 −1。
 * 
 * 数据范围
 * 1≤N≤105
 * 1≤数列中元素≤109
 * 
 * 样例
 * 输入样例：
 * 5
 * 3 4 2 7 5
 * 输出样例：
 * -1 3 -1 2 2
 */
class AcWing830 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] stk = new int[m];
        Arrays.fill(stk, -1);
        int tt = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            while (tt > 0 && stk[tt] >= x)
                tt--;
            if (tt == 0) {
                System.out.print("-1 ");
            } else {
                System.out.print(stk[tt] + " ");
            }
            stk[++tt] = x;
        }
    }
}
