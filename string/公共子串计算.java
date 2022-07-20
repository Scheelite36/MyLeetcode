package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：1\le s\le 150\1≤s≤150
 * 进阶：时间复杂度：O(n^3)\O(n
 * 3
 * ) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 * 
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 * 
 * 输入：
 * asdfas
 * werasdfaswer
 * 输出：
 * 6
 */
public class 公共子串计算 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (j > b.length - res) {
                    break;
                }
                int len = 0;
                int ii = i;
                int jj = j;
                while (ii < a.length && jj < b.length && a[ii] == b[jj]) {
                    len++;
                    ii++;
                    jj++;
                }
                res = Math.max(res, len);
            }
        }
        System.out.println(res);
    }
}
