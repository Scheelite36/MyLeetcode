#
# @lc app=leetcode.cn id=7 lang=python3
#
# [7] 整数反转
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        rest = 0
        op = 1 if x>0 else -1
        while x != 0:
            rest = rest * 10 + abs(x) % 10
            x = abs(x) // 10
        if -2**31 > rest or rest > 2**31-1:
            return 0
        return rest*op       

# @lc code=end

