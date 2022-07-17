import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

 

示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0

如果我们将面值看作是物品，面值金额看成是物品的重量，每件物品的价值均为1，
这样此题就是是一个恰好装满的完全背包问题了。不过这里不是求最多装入多少物品而是求最少，
我们只需要将2.2节的转态转移方程中的max改成min即可，又由于是恰好装满，所以除了dp[0]，
其他都应初始化为INT_MAX
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=0;i<n;i++){
            for (int j=coins[i];j <=amount; j++){
            // 下行代码会在 1+INT_MAX 时溢出
            // dp[j] = min(dp[j], 1 + dp[j - coins[i-1]]); 
            if(dp[j] - 1 > dp[j - coins[i]])
                dp[j] = 1 + dp[j - coins[i]];  
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
// @lc code=end

