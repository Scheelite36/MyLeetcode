package trackBack;

import java.io.IOException;
import java.util.Scanner;

/**
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
输入描述：
读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。

输出描述：
对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false

输入：
7 2 1 10
输出：
true
 */

class Mian6 {

    public static char[] op = new char[]{'+','-','*','/'};
    public static boolean res = false;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[4];
        int i=0;
        while(i < 4){
            nums[i] = in.nextInt();
            i++;
        }
        boolean[] isVisited = new boolean[4];
        for (int l=0;l<4;l++){
            isVisited[l] = true;
            traceBack(nums, isVisited, (double)nums[l]);
            isVisited[l] = false;
        }
        if (!res){
            System.out.println("false");
        }else {
            System.out.println("true");
        }
        
    }

    public static void traceBack(int[] nums, boolean[] isVisited, Double now){
        if (now == 24.0d){
            res = true;
            return;
        }
        for (int i=0; i<4;i++){
            if (!isVisited[i]){
                isVisited[i] = true;
                for (char c : op){
                    traceBack(nums, isVisited, cal(now, (double)nums[i], c));
                }
                isVisited[i] = false;
            }
        }
        return;
    }
    
    public static Double cal(Double i, Double j, char c){
        switch(c){
            case '*':
                return i*j;
            case '/':
                return i/j;
            case '+':
                return i+j;
            case '-':
                return i-j;
            default:
                return 0d;
        }
    }
}
