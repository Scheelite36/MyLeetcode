package hash;

import java.util.Scanner;

/**
 * 题目描述
给定一个长度为n的字符串，再给定m个询问，每个询问包含四个整数l1,r1,l2,r2，请你判断[l1,r1]和[l2,r2]这两个区间所包含的字符串子串是否完全相同。

字符串中只包含大小写英文字母和数字。

输入格式
第一行包含整数n和m，表示字符串长度和询问次数。

第二行包含一个长度为n的字符串，字符串中只包含大小写英文字母和数字。

接下来m行，每行包含四个整数l1,r1,l2,r2，表示一次询问所涉及的两个区间。

注意，字符串的位置从1开始编号。

输出格式
对于每个询问输出一个结果，如果两个字符串子串完全相同则输出“Yes”，否则输出“No”。

每个结果占一行。

数据范围
1≤n,m≤105

样例
输入样例：
8 3
aabbaabb
1 3 5 7
1 3 6 8
1 2 1 2
输出样例：
Yes
No
Yes

作者：wuog
链接：https://www.acwing.com/solution/content/3613/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing841 {
    static String s;
    static final int P = 131;
    static long[] h;
    static long[] p;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        s = scanner.nextLine();
        p = new long[n+1]; h = new long[n+1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i-1]*P;
            h[i] = h[i-1]*P + s.charAt(i-1);
        }
        int[][] ij  = new int[m][4]; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                ij[i][j] = scanner.nextInt();
            }
        }
        for (int[] is : ij) {
            if (getHash(is[0], is[1]) == getHash(is[2], is[3])) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
        scanner.close();    
    }

    static long getHash(int i, int j){
        return h[j] - h[i-1] * p[j-i+1];
    }

}
