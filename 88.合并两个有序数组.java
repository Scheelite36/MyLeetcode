
/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 倒序进行筛选合并
        int i1 = m-1;
        int i2 = n-1;
        int tail = m+n-1;
        int cur;
        while(i1>-1 || i2>-1){
            if(i1==-1){
                cur = nums2[i2--];
            }else if(i2==-1){
                cur = nums1[i1--];
            }else if(nums1[i1] > nums2[i2]){
                cur = nums1[i1--];
            }else{
                cur = nums2[i2--];
            }
            nums1[tail--] = cur;
        }
    }
}
// @lc code=end

