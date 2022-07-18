package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述:四则运算
 * 输入：
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 输出：
 * 25
 * 
 * 解法：
 * 1. 用两个栈分别压数字和运算符；
 * 2. 如果当前运算符优先级*\/高于栈顶运算符+-优先级，则将运算符入栈；反之，从数字栈中弹出两个数，从运算符栈中弹出栈顶运算符，进行运算，
 *    数字栈压入运算结果，符号栈压入当前运算符。重复该操作直到不满足条件。出现左括号，则直接压入；
 * 3. 出现右括号，则从数字栈中弹出两个数，从运算符栈中弹出栈顶运算符，进行运算，数字栈压入运算结果，重复该操作直到栈顶弹出右括号位置。
 *
 * @date 2022-07-12
 */
class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s.replace("[", "(");
        s.replace("{", "(");
        s.replace("}", ")");
        s.replace("]", ")");
        s.replace(")(", ")*(");
        String op1 = "*/";
        String op2 = "+-";
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> charStack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                // 读取所有数字
                int num = c - '0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    i++;
                    num = num*10 + (s.charAt(i)-'0');
                }
                numStack.push(num);
            } else if (c)
        }
    }


}
