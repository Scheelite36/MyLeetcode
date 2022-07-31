#
# @lc app=leetcode.cn id=220 lang=python3
#
# [220] 存在重复元素 III
#

# @lc code=start
from typing import List


class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        le = len(nums)
        # 加1是针对t=0情况 w桶的大小
        w = t+1
        di = {}
        for i in range(le):
            # 获取桶的编号
            id = nums[i] // w
            # 如果对应桶中已经存在数了 说明二者序号在k内且大小相差t
            if id in di:
                return True
            elif (id-1 in di) and (abs(nums[i]-di.get(id-1)) < w):
                return True
            elif (id+1 in di) and (abs(nums[i]-di.get(id+1)) < w):
                return True
            di[id] = nums[i]
            if i >= k:
                di.pop(nums[i-k] // w)
        return False

# @lc code=end

