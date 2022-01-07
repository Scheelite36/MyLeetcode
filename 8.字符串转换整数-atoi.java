/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        // 一次遍历 flag用于判断是否读到了 数字或者+ - 此后直接非数字就退出
        int sign = 1;
        boolean flag = true;
        long r = 0l;
        for(char c :s.toCharArray()){
            if(!(c>=48&&c<=57)){
                if(flag==true){
                    if(c==45){
                        sign = -1;
                        flag = false;
                        continue;
                    }
                    if(c==43){
                        sign = 1;
                        flag = false;
                        continue;
                    }
                    if(c==32){
                        continue;
                    }
                }
                flag = false;
                break;
            }
            if((r*10+(int)(c-48))>Integer.MAX_VALUE){
                if(sign==1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            r = r*10+(int)(c-48);
            flag=false;
        }
        return (int)(r*sign);
    }
}
// @lc code=end

