import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 * 
 * 给你一个整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

 

示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：

输入：nums = [1], target = 1
输出：1
 * 
 * 
 * 假设所有元素和为sum，所有添加正号的元素的和为A，所有添加负号的元素和为B，
 * 则有sum = A + B 且 S = A - B，解方程得A = (sum + S)/2。即题目转换成：
 * 从数组中选取一些元素使和恰好为(sum + S) / 2。可见这是一个恰好装满的01背包问题，
 * 要求所有方案数，将1.2节状态转移方程中的max改成求和即可。需要注意的是，虽然这里是恰好装满，
 * 但是dp初始值不应该是inf，因为这里求的不是总价值而是方案数，应该全部初始为0（除了dp[0]初始化为1）。
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 添加正号的元素和为A 添加负号的元素和为B sum = A+B； target = A-B
        // A = （sum+target)/2 在nums中找到和恰好为A的元素的最大方案
        // 转化为了 需要恰好装满的01背包问题
        int n = nums.length, sum=0;
        for(int m:nums){
            sum+=m;
        }
        if (sum<target || sum < -target) return 0;
        // A 不是整数
        if ((sum+target) % 2 == 1) return 0;
        target = (sum+target)/2;
        int[] dp = new int[target+1];
        // 在第1个元素总和为0的方案数为1（就是不选这个数）
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j] = dp[j]+dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
// @lc code=end

