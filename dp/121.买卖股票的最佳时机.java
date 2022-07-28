package dp;
/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * 
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            minPrice = Integer.min(price, minPrice);
            maxProfit = Integer.max(price - minPrice, maxProfit);
        }
        return maxProfit;
    }
}

/**
 * dp[i] 第i天为止可以得到的最大利润
 * 当然 可以直接使用用变量直接记录 节省空间
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int min = prices[0];
        int[] dp = new int[len+1];
        for (int i = 1; i < len+1; i++) {
            min = Math.min(min, prices[i-1]);
            dp[i] = Math.max(dp[i-1],prices[i-1]-min);
        }
        return dp[len];
    }
}
// @lc code=end
