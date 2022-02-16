import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        // 用第一个进行全部匹配，匹配不上就减小一位
        String s = strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(string.length()==0){
                    return "";
                }
                s = s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}
// @lc code=end

