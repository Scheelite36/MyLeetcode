/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price:prices){
            minPrice = Integer.min(price, minPrice);
            maxProfit = Integer.max(price-minPrice, maxProfit);
        }
        return maxProfit;
    }

}
// @lc code=end

