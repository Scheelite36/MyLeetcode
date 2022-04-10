/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // 二分查找
    public int firstBadVersion(int n) {
        int right = n,left = 1;
        int mid = 1;
        while(left<right){
            mid = (right-left)/2 + left;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

