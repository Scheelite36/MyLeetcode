#
# @lc app=leetcode.cn id=344 lang=python3
#
# [344] 反转字符串
#

# @lc code=start
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        # 双指针遍历
        for i in range(0,int(len(s)/2)):
            s[i],s[len(s)-1-i] = s[len(s)-1-i],s[i]
# @lc code=end

