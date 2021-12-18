#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#

# @lc code=start
class Solution:
    def firstUniqChar(self, s: str) -> int:
        # 新建26个ascii数字的字典 默认key为0
        di = dict.fromkeys(range(26),0)
        for i in s:
            di[ord(i)-97]+=1
        for i in s:
            if di[ord(i)-97] == 1:
                return s.index(i)
        return -1     
# @lc code=end

