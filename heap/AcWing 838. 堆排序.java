package heap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 题目描述
输入一个长度为 n 的整数数列，从小到大输出前 m 小的数。

输入格式
第一行包含整数 n 和 m。

第二行包含 n 个整数，表示整数数列。

输出格式
共一行，包含 m 个整数，表示整数数列中前 m 小的数。

数据范围
1≤m≤n≤105，
1≤数列中元素≤109

输入样例:
5 3
4 5 1 3 2
输出样例
1 2 3
 */
class AcWing838 {
    static int[] h;
    static int size;
    static void down(int x){
        int m = x;
        if (2*x <= size && h[2*x] < h[m]) m = 2 * x;
        if (2*x+1 <= size && h[2*x+1] < h[m]) m = 2*x+1;
        if(m != x){
            int t = h[x];
            h[x] = h[m];
            h[m] = t;
            down(m);
        }
    }
    static int delMin(){
        int r = h[1];
        h[1] = h[size];
        size--;
        down(1);
        return r;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        h = new int[n+1];
        size = n;
        int m = sc.nextInt();
        sc.skip("\n");
        for (int i = 1; i <= n; i++) {
            h[i] = sc.nextInt();
        }
        for (int i = n/2; i > 0 ; i--) {
            down(i);
        }
        while(m-- > 0){
            System.out.print(delMin()+" ");
        }
    }
}
