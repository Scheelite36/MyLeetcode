package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 
 * 整数除法仅保留整数部分。
 * 
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：s = "3+2*2"
 * 输出：7
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution227 {
    static String ops = "+-*/";
    public int calculate(String s) {
        Deque<Integer> num = new LinkedList<>();
        Deque<Character> op = new LinkedList<>();
        s = s.trim();
        for (int i=0; i<s.length();i++){
            if (s.charAt(i)==' '){
                continue;
            }
            // 符号
            if (!Character.isDigit(s.charAt(i))){
                char c = s.charAt(i);
                int left = getDigitIndex(s, ++i);
                num.push(Integer.valueOf(s.substring(i, left)));
                cal(num, op, c);
                i = left;
            }else{
                num.push(Integer.valueOf(s.substring(i,getDigitIndex(s, i))));
            }
            
        }
        return num.peek();
    }
    public int getDigitIndex(String s, int i){
        while(Character.isDigit(s.charAt(i)) || s.charAt(i)==' '){
            ++i;
        }
        return i;
    }
    public void cal(Deque<Integer> num, Deque<Character> op, char c){
        if ( ops.indexOf(op.peek()) < 2){
            if (ops.indexOf(c) > 1){
                num.push(op(num.pop(), num.pop(), c));
            }
        }
        num.push(op(num.pop(),num.pop(), op.pop()));
    }

    public int op(int a, int b, char c){
        switch(c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                return 0;
        }
    }
}
