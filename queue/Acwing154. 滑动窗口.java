package queue;

import java.util.Scanner;

/**
 * 给定一个大小为 n≤106 的数组。
 * 
 * 有一个大小为 k 的滑动窗口，它从数组的最左边移动到最右边。
 * 
 * 你只能在窗口中看到 k 个数字。
 * 
 * 每次滑动窗口向右移动一个位置。
 * 
 * 以下是一个例子：
 * 
 * 该数组为 [1 3 -1 -3 5 3 6 7]，k 为 3。
 * 
 * 窗口位置 最小值 最大值
 * [1 3 -1] -3 5 3 6 7 -1 3
 * 1 [3 -1 -3] 5 3 6 7 -3 3
 * 1 3 [-1 -3 5] 3 6 7 -3 5
 * 1 3 -1 [-3 5 3] 6 7 -3 5
 * 1 3 -1 -3 [5 3 6] 7 3 6
 * 1 3 -1 -3 5 [3 6 7] 3 7
 * 你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
 * 
 * 输入格式
 * 输入包含两行。
 * 
 * 第一行包含两个整数 n 和 k，分别代表数组长度和滑动窗口的长度。
 * 
 * 第二行有 n 个整数，代表数组的具体数值。
 * 
 * 同行数据之间用空格隔开。
 * 
 * 输出格式
 * 输出包含两个。
 * 
 * 第一行输出，从左至右，每个位置滑动窗口中的最小值。
 * 
 * 第二行输出，从左至右，每个位置滑动窗口中的最大值。
 * 
 * 输入样例：
8 3
1 3 -1 -3 5 3 6 7
 * 输出样例：
 * -1 -3 -3 -3 3 3
 * 3 3 5 5 6 7
 */
class Acwing154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] q = new int[m];
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        // 找到区间内最小
        int hh = 0, tt = -1;
        for (int i = 0; i < m; i++) {
            while (hh <= tt && i - k + 1 > q[hh])
                hh++;
            while (hh <= tt && nums[q[tt]] >= nums[i])
                tt--;
            q[++tt] = i;
            if (i-k+1>=0) System.out.print(nums[q[hh]]+" ");
        }
        // 找到区间最大值
        System.out.println();
        hh = 0; tt = -1;
        for (int i = 0; i < m; i++) {
            while (hh <= tt && i - k + 1 > q[hh])
                hh++;
            while (hh <= tt && nums[q[tt]] <= nums[i])
                tt--;
            q[++tt] = i;
            if (i-k+1>=0) System.out.print(nums[q[hh]]+" ");
        }
    }
}
