package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
 * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫
 * Levenshtein Distance 。
 * 
 * 例如：
 * 字符串A: abcdefg
 * 字符串B: abcdef
 * 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 * 
 * 要求：
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 * 
 * 数据范围：给定的字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
 * 
 * 输入描述：
 * 每组用例一共2行，为输入的两个字符串
 * 
 * 输出描述：
 * 每组用例输出一行，代表字符串的距离
 * 
 * 输入：
 * abcdefg
 * abcdef
 * 
 * 输出：
 * 1
 * 
 * dp[i][j] 从a字符前i位置和b字符前j位置相等需要的最少步数
 * 对于dp[i][j], 可以是
 * 1. a字符串i位置的替换为b字符串j位置，则 dp[i][j] = dp[i-1][j-1]+1
 * 2. a字符串i位置直接增加 则dp[i][j] = dp[i-1][j]+1
 * 3. a字符串位置直接删减 则dp[i][j] = dp[i][j-1]+1
 * 
 * 初始化从dp[i][0] 为 i, dp[0][j] 为j。 到空串的距离是i 或 j
 */
class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for(int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    // 第一种情况 替换
                    int road1 = dp[i-1][j-1]+1;
                    // 第二种情况 增加
                    int road2 = dp[i-1][j]+1;
                    // 第三种情况 删除
                    dp[i][j] = Math.min(road1,Math.min(road2,dp[i][j-1]+1));
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}