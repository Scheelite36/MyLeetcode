from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:

        def quick_sort(nums, l, r):
            if l >= r:
                return
            x = nums[l]; i = l - 1; j = r + 1
            while i < j :
                i += 1
                while nums[i] < x:
                    i += 1
                j -= 1
                while nums[j] > x:
                    j -= 1
                if i < j:
                    nums[i],nums[j] = nums[j],nums[i]
            quick_sort(nums, l, j)
            quick_sort(nums, j+1, r)

        quick_sort(nums, 0, len(nums)-1)
        return nums


if __name__ == "__main__":
    s = Solution()
    nums = [5,1,1,6,0,0]
    s.sortArray(nums=nums)
    print(nums)

# 2 4 6 3 6 1 0
