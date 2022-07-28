package dp;
/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (price - minPrice > 0) {
                maxProfit += price - minPrice;
                minPrice = price;
            }
            minPrice = Integer.min(price, minPrice);
        }
        return maxProfit;
    }
}

class Solution2 {
    // todo
    
}
// @lc code=end
