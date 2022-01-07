/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solutio {
    public static int myAtoi(String s) {
        // StringBuilder sb = new StringBuilder();
        long flag = 1l;
        boolean space_flag = true;
        long r = 0l;
        for(char c :s.toCharArray()){
            if(!(c>=48&&c<=57)){
                if(c==45&&flag!=-1){
                    flag = -1;
                    space_flag = false;
                    continue;
                }
                if(c==32&& space_flag==true){
                    continue;
                }
                space_flag = false;
                break;
            }
            if((r*10+(int)(c-48))>Integer.MAX_VALUE && flag == 1){
                return (int)(r*flag);
            }
            r = r*10+(int)(c-48);
        }
        return (int)(r*flag);
    }

    public static void main(String[] args) {
        System.out.println(new Solutio().myAtoi("      -2147483647"));
        System.out.println(Integer.MAX_VALUE);
    }
}
// @lc code=end

