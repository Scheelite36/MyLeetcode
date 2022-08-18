package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
    Map<Character,Integer> map = new HashMap<>(){{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};
    public int calculate(String s) {
        Deque<Integer> num = new LinkedList<>();
        Deque<Character> op = new LinkedList<>();
        s =s.replace(" ", "");
        for (int i=0; i<s.length();i++){
            if (Character.isDigit(s.charAt(i))){
                int start = i;
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    ++i;
                }
                num.push(Integer.valueOf(s.substring(start, i+1)));
            }else {
                // 当栈内运算符优先级和当前同级或者比当前高 就进行循环运算
                while (!op.isEmpty() && map.get(op.peek()) >= map.get(s.charAt(i))){
                    cal(num, op);
                }
                op.push(s.charAt(i));
            }
        }
        // 将剩下的计算完成
        while(!op.isEmpty()) cal(num,op);
        return num.peek();
    }

    public int getDigitIndex(String s, int i){
        while(Character.isDigit(s.charAt(i)) || s.charAt(i)==' '){
            ++i;
        }
        return i;
    }

    public void cal(Deque<Integer> num, Deque<Character> op){
        int b = num.pop();
        int a = num.pop();
        num.push(op(a,b,op.pop()));
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
    public static void main(String[] args) {
        Solution227 s = new Solution227();
        s.calculate("1*2-3/4+5*6-7*8+9/10");
    }
}
