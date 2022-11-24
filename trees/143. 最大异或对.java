package trees;

import java.util.Scanner;

/**
 * 在给定的 N 个整数 A1，A2……AN 中选出两个进行 xor（异或）运算，得到的结果最大是多少？

输入格式
第一行输入一个整数 N。

第二行输入 N 个整数 A1～AN。

输出格式
输出一个整数表示答案。

数据范围
1≤N≤10^5,
0≤Ai<2^31
输入样例：
3
1 2 3
输出样例：
3
 */
class AcWing143 {
    int[][] trie = new int[3100000][2];
    int idx = 0;
    
    void insert(int x){
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = x >> i & 1;
             if (trie[p][bit] == 0) trie[p][bit] = ++idx;
            p  = trie[p][bit];
        }
    }

    int search(int x){
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            // 该位取反
            int _bit = ~(x >> i) & 1;
            int bit = x >> i & 1;
            if (trie[p][_bit] != 0){
                p = trie[p][_bit];
                res = res * 2 + 1;
            }else {
                p = trie[p][bit];
                res = res * 2 + 0;
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int[] input = new int[m];
        int res = 0;
        AcWing143 ac = new AcWing143();
        for (int i = 0; i < m; i++) {
            input[i] = scan.nextInt();
            ac.insert(input[i]);
        }
        for (int i = 0; i < m; i++) {
            res = Math.max(res, ac.search(input[i]));
        }
        System.out.println(res);
    }
}
