/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 遍历后把非零数字放前面，最后的数补0（速度快占内存）
        int index=0;
        for(int num:nums){
            if(num!=0){
                nums[index++] = num;
            }
        }
        for (int i=index;i<nums.length;i++){
            nums[i]=0;
        }
        //双指针法
        // int left =0;
        // int right =1;
        // while(right<nums.length){
        //     if(nums[left]==0){
        //         if(nums[right]!=0){
        //             nums[left] =nums[right];
        //             nums[right]=0;
        //             right++;
        //             left++;
        //             continue;
        //         }
        //         right++;
        //     }else{
        //         left = right++;
        //     }
        // }
    }
}
// @lc code=end

