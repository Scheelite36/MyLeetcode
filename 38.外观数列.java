/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        int count = 1;
        char[] chars = countAndSay(n-1).toCharArray();
        char c = chars[0];
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<chars.length;i++){
            if(chars[i] != c){
                c = chars[i];
                sb.append(count).append(chars[i-1]);
                count = 1;
            }else{
                count++;
            }
        }
        return sb.append(count).append(c).toString();
    }
}
// @lc code=end

