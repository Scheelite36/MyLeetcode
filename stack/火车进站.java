package stack;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 数据范围：1\le n\le 10\1≤n≤10
 * 进阶：时间复杂度：O(n!)\O(n!) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 * 
 * 输入：
 * 3
 * 1 2 3
 * 输出：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 说明：
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 */
public class 火车进站 {
    public static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Deque<Integer> stack = new LinkedList<>();
        Collections.sort(res);
        res.forEach(System.out::println);

    }

    /**
     * i 进站火车index
     * count 出站火车数量
     */
    public void traceBack(int[] nums, Deque<Integer> stack, int i, String s, int count) {
        if (count == nums.length) {
            res.add(s);
        }
        if (!stack.isEmpty()) {
            // 进站后立刻出站
            int temp = stack.pop();
            traceBack(nums, stack, i, s + temp + " ", count + 1);
            // 恢复
            stack.push(temp);
        }
        if (i < nums.length) {
            // 火车进站
            stack.push(nums[i]);
            traceBack(nums, stack, i + 1, s, count);
            // 恢复
            stack.pop();
        }
    }
}