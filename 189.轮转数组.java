/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // 建立新的数组 对照赋值
        int n = nums.length;
        k = k % n;
        if(k==0){
            return;
        }
        int[] new_nums = nums.clone();
        for(int i=0; i< n; i++){
            if(i<k){
                nums[i] = new_nums[n-k+i];  
            }else{
                nums[i] = new_nums[i-k];
            }
        }
    }
}
// @lc code=end

