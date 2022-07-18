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
 * 3*5+8-0*3-6+0+0
 * 17
 * 
 * 解法：
 * 1. 用两个栈分别压数字和运算符；
 * 2. 如果当前运算符优先级* /高于栈顶运算符+-优先级，则将运算符入栈；反之
 *  1）栈顶为+- 当前也为+-
 *  2）栈顶为* / 当前为+-
 * ，从数字栈中弹出两个数，从运算符栈中弹出栈顶运算符，进行运算，
 * 数字栈压入运算结果，符号栈压入当前运算符。重复该操作直到不满足条件。出现左括号，则直接压入；
 * 3. 出现右括号，则从数字栈中弹出两个数，从运算符栈中弹出栈顶运算符，进行运算，数字栈压入运算结果，重复该操作直到栈顶弹出左括号位置。
 *
 * @date 2022-07-12
 */
class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replace("[", "(");
        s = s.replace("{", "(");
        s = s.replace("}", ")");
        s = s.replace("]", ")");
        s = s.replace(")(", ")*(");
        String op1 = "*/";
        String op2 = "+-";
        String op3 = "()";
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> charStack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                // 读取该数字
                int num = c - '0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    i++;
                    num = num*10 + (s.charAt(i)-'0');
                }
                numStack.push(num);
            } else if (op1.contains(String.valueOf(c))){
                charStack.push(s.charAt(i));
            } else if (op2.contains(String.valueOf(c))){
                //负数 -x 或者（-x 这样
                if (c == '-' && (i-1 == -1 || s.charAt(i-1)=='(')){
                    i++;
                    int num = s.charAt(i) - '0';
                    while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                        i++;
                        num = num*10 + (s.charAt(i)-'0');
                    }
                    numStack.push(0-num);
                    continue;
                }
                // + - 循环进行运算
                while (charStack.peek() != null && !op3.contains(String.valueOf(charStack.peek()))){
                    cal(numStack, charStack);
                }
                charStack.push(c);
            } else if(c=='('){
                charStack.push(c);
            }else{
                while(charStack.peek() != '('){
                    cal(numStack, charStack);
                }
                charStack.pop();
            }
        }
        while(numStack.size() > 1){
            cal(numStack, charStack);
        }
        System.out.println(numStack.pop());
    }

    public static void cal(Deque<Integer> numStack, Deque<Character> charStack) {
        int a = numStack.pop();
        int b = numStack.pop();
        char c = charStack.pop();
        switch (c) {
            case '*':
                numStack.push(b * a);
                break;
            case '/':
                numStack.push(b / a);
                break;
            case '+':
                numStack.push(b + a);
                break;
            case '-':
                numStack.push(b - a);
                break;
        }
    }
}
