package stack;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class 矩阵乘法计算量估算 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 队列存放保存的矩阵
        Deque<int[]> matrix = new ArrayDeque<>(n);
        while (n-- >0){
            int x = in.nextInt();
            int y = in.nextInt();
            matrix.offer(new int[]{x,y});
        }
        String str = in.nextLine();
        str = in.nextLine();
        // 使用两个栈保存矩阵和符号信息
        Deque<int[]> matrixStack = new LinkedList<>();
        Deque<Character> signStack = new LinkedList<>();
        int res = 0;
        for (char c : str.toCharArray()){
            if (c=='('){
                signStack.push(c);
            } else if (c==')'){
                // 碰到）取出两个矩阵计算
                // 计算res 新的matrix
                int[] matrixb = matrixStack.pop();
                int[] matrixa = matrixStack.pop();
                res += matrixa[0]*matrixa[1]*matrixb[1];
                matrixStack.push(new int[]{matrixa[0],matrixb[1]});
                signStack.pop();
            }else {
                // 将队列头部矩阵push到栈中
                matrixStack.push(matrix.poll());
            }
        }
        System.out.println(res);
    }
}
