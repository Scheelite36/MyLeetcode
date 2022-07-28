#
# @lc app=leetcode.cn id=121 lang=python3
#
# [121] 买卖股票的最佳时机
#

# @lc code=start
from typing import List


class Solution:
    
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        minTemp = 0
        # 找到相对最小值 依次向后计算gap
        for i in range(len(prices)-1):
            if prices[i+1] <= prices[minTemp]:
                minTemp = i+1
                continue
            if prices[i+1] - prices[minTemp] > profit:
                profit = prices[i+1]-prices[minTemp]
        return profit
# @lc code=end

