package dp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * n 道菜 m 手速（下菜后等几秒才能夹菜）
 * x y 分别是 下菜 和 熟透时间
 * 问能最多吃到多少道菜
 * 2 1
 * 1 2
 * 2 1
 * 
 * @param args
 */
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        Integer m = in.nextInt();
        int[] dishes = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dishes[i] = in.nextInt() + in.nextInt();
        }
        int[] dp = new int[n + 1];
        // int[] time = new int[n+1];
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            // 不能从上一道菜吃到
            if (dishes[i] < dishes[i - 1] + m) {
                // 找能吃到的
                for (int j = i - 2; j > 0; j--) {
                    while (j > 0 && dishes[j] + m <= dishes[i - 1]) {
                        dp[i] = dp[j] + 1;
                        break;
                    }
                }
            } else {
                // 能吃到
                dp[i] = dp[i - 1] + 1;
            }
        }
        for (int d : dp) {
            max = Math.max(d, max);
        }
        System.out.println(n);
    }
}
