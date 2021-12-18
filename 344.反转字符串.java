/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
    private void reverse(char[]s,int left,int right){
        if(left>right){
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, ++left, --right);
    }
}
// @lc code=end

