/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        boolean n_flag = false;
        for (char c : s.toCharArray()) {
            if(!(c>=48 && c<=57)){
                if(c==45&&flag==false){
                    sb.append(c);
                    flag=true;
                    n_flag=true;
                    continue;
                }else if(c==32&&n_flag==false){
                    continue;
                }
                break;
            }
            n_flag=true;
            sb.append(c);
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            //TODO: handle exception
            return 0;
        }
    }
}
// @lc code=end

