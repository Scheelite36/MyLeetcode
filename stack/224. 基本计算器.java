package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 
 *  
 * 
 * 示例 3：
 * 
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 * 
 * 提示：
 * 
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution224 {
    public int calculate(String s) {
        Deque<Integer> num = new LinkedList<>();
        Deque<Character> op = new LinkedList<>();
        s = s.replace(" ", "");
        if (s.startsWith("-"))
            num.push(0);
        char[] sa = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(sa[i])) {
                int start = i;
                while (i + 1 < s.length() && Character.isDigit(sa[i + 1])) {
                    ++i;
                }
                num.push(Integer.valueOf(s.substring(start, i + 1)));
            } else {
                // 碰到右括号直接计算到左括号为止
                if (sa[i] == ')') {
                    while (op.peek() != '(') {
                        cal(num, op);
                    }
                    op.pop();
                } else {
                    // 如果不是右括号的话就直接进行计算
                    // 判断是否符合计算条件 当前是运算符号不是括号且符号栈中有运算符号
                    while (!op.isEmpty() && op.peek() != '(' && sa[i] != '(') {
                        cal(num, op);
                    }
                    // 处理（-x)这种情况
                    if (i>0 && sa[i]!='(' && sa[i-1] == '('){
                        num.push(0);
                    }
                    op.push(sa[i]);
                }
            }
        }
        // 计算剩下的
        while (!op.isEmpty())
            cal(num, op);
        return num.peek();
    }

    public void cal(Deque<Integer> num, Deque<Character> op) {
        int b = num.pop();
        int a = num.pop();
        char o = op.pop();
        switch (o) {
            case '+':
                num.push(a + b);
                break;
            case '-':
                num.push(a - b);
                break;
        }
    }

    public static void main(String[] args) {
        Solution224 s = new Solution224();
        s.calculate("(1+(4+5+2)-3)+(6+8)");
    }
}