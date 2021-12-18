/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        for(int right=1;right<nums.length;right++){
            // 左指针不等于右指针 将左指针前进一位，并将右指针的值赋值给左指针
            if(nums[left]!=nums[right]){
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }
}
// @lc code=end

