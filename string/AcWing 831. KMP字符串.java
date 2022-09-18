package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一个模式串S，以及一个模板串P，所有字符串中只包含大小写英文字母以及阿拉伯数字。
 * 
 * 模板串P在模式串S中多次作为子串出现。
 * 
 * 求出模板串P在模式串S中所有出现的位置的起始下标。
 * 
 * 输入格式
 * 第一行输入整数N，表示字符串P的长度。
 * 
 * 第二行输入字符串P。
 * 
 * 第三行输入整数M，表示字符串S的长度。
 * 
 * 第四行输入字符串S。
 * 
 * 输出格式
 * 共一行，输出所有出现位置的起始下标（下标从0开始计数），整数之间用空格隔开。
 * 
 * 数据范围
 * 1≤N≤105
 * 1≤M≤106
 * 
 * 样例
3
aba
5
ababa
 * 
 * 作者：林小鹿
 * 链接：https://www.acwing.com/solution/content/15472/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing831 {
    static char[] s;
    static char[] p;
    static int[] next;
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        next = new int[m];
        sc.nextLine();
        p = sc.nextLine().toCharArray();
        n = sc.nextInt();
        sc.nextLine();
        s = sc.nextLine().toCharArray();
        getNext();
        List<Integer> res = new ArrayList<>();
        pattern(res);
        for (Integer integer : res) {
            System.out.print(integer + " ");
        }
    }
    
    static void getNext(){
        for (int i = 1, j=-1; i < m; i++) {
            while(j>-1 && p[i]!=p[j+1]) j=next[j];
            if (p[i]==p[j+1]) j++;
            next[i] = j;
        }
    }

    static void pattern(List<Integer> res){
        for (int i = 0,j=-1; i < n; i++) {
            while(j>-1&&s[i]!=p[j+1]) j=next[j];
            if (s[i]==p[j+1]) j++;
            if(j==m-1){
                res.add(i-m+1);
                j = next[j];
            }
        }
    }
}
