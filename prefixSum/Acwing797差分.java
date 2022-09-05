package prefixSum;

import java.io.IOException;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一个长度为 n 的整数序列。
 * 接下来输入 m 个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r] 之间的每个数加上 c。
 * 请你输出进行完所有操作后的序列。
 * 
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 * 第二行包含 n 个整数，表示整数序列。
 * 接下来 m 行，每行包含三个整数 l，r，c，表示一个操作。
 * 
 * 输出格式
 * 共一行，包含 n 个整数，表示最终序列。
 * 
 * 输入样例
 * 6 3
 * 1 2 2 1 2 1
 * 1 3 1
 * 3 5 1
 * 1 6 1
 * 输出样例
 * 3 4 5 3 4 2
 */
class ACwing797 {
    static int[] diff;

    static void insert(int l, int r, int c) {
        diff[l] += c;
        diff[r + 1] -= c;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        //构造差分数组
        diff = new int[n+2];
        for (int i = 1; i <= n; i++) {
            insert(i, i, nums[i]);
        }
        while (m-- > 0) {
            insert(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i-1];
            System.out.print(diff[i]+" ");
        }
    }
}
