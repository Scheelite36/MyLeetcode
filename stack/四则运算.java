package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 描述:四则运算
 * 输入：
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 输出：
 * 25
 *
 * @date 2022-07-12
 */
class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = bfr.readLine()) != null) {
            input = input.replace("[", "(");
            input = input.replace("{", "(");
            input = input.replace("}", ")");
            input = input.replace("]", ")");
            input = input.replace(")(", ")*(");// 考虑到(xxx)(xxx)情况,中间加上*
            int result = cal(input);
            System.out.println(result);
        }
    }

    /*
     * 四则运算计算
     * 示例: 3+(9-7)-5*2+6
     * 本方法处理说明:
     * 1. (9-7)会被拆出来处理为2, 实际算式为3+2-5*2+6
     * 2. 该算式可以看做是四个分段的和:3, 2, -5*2, 6 (这些分段是以加减号分割的)
     * 3. 从左到右处理,当处理到减号时,减号之前的符号是加号,加号可分段(分段即表示两段结果互不影响),那么左边的3可以合并到result; +2同理
     * 4. 当处理到最后一个加号时,加号之前的符号是*号,该符号不分段,不用将-5合并到result,temp=temp*number=-5*2=-10;
     * 5. 处理到最后一位6时,加号,分段,将-10合并到result,最后一位6单独分一段;
     * 6. 将最后一个分段的结果合并到result,最终结果1.
     */
    private static int cal(String str) {
        if (str.length() == 0)
            return 0;
        char[] cs = str.toCharArray();
        char sign = '+';// sign表示上一个运算符,默认为+,表示0+
        int result = 0;// 结果值,将每一段的结果合并(以加减分隔段)
        int temp = 0;// 临时中间值,sign运算符左边的值
        int number = 0;// sign运算符右边的值
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (Character.isDigit(c)) {// 字符串转数值
                number = number * 10 + c - '0';
            } else if (c == '(') {// 去括号(将括号中的内容转成数值)
                int count = 1;
                int j = i;
                while (count > 0) {
                    j++;
                    if (cs[j] == ')')
                        count--;
                    if (cs[j] == '(')
                        count++;
                }
                number = cal(str.substring(i + 1, j));// 将括号中的内容截取,j位置是一个")"
                i = j;
            }
            // 每接收到一个新的运算符,都要处理sign运算符,最后一位时也要处理
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == cs.length - 1) {
                if (sign == '+') {// 前一个运算符为加号,那么sign运算符左边的数值可以直接合并到result
                    result += temp;
                    temp = number;// temp相当于栈顶,将number压入栈顶
                } else if (sign == '-') {// 减号同加号
                    result += temp;
                    temp = -1 * number;
                } else if (sign == '*') {// 前一个运算符为乘号,那么sign运算符左边的数值需要直接乘右边的值,还不能合并到result
                    temp *= number;
                } else if (sign == '/') {
                    temp /= number;
                }
                number = 0;// number置空,等待接收新值
                sign = c;// 将新符号更新到sign
            }
        }
        result += temp;// 将sign运算符右边的值也合并到result
        return result;
    }
}
