package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
入职后，导师会请你吃饭，你选择了火锅。

火锅里会在不同时间下很多菜。

不同食材要煮不同的时间，才能变得刚好合适。

你希望吃到最多的刚好合适的菜，但你的手速不够快，用m代表手速，每次下手捞菜后至少要过m秒才能再捞（每次只能捞一个）。

那么用最合理的策略，最多能吃到多少刚好合适的菜？

输入描述
第一行两个整数n，m，其中n代表往锅里下的菜的个数，m代表手速。（1 < n, m < 1000）

接下来有n行，每行有两个数x，y代表第x秒下的菜过y秒才能变得刚好合适。（1 < x, y < 1000）

输出描述
输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量。

用例
输入	
2 1
1 2
2 1
输出
1
5 3
1 2
2 3
2 1
3 2
4 2
 */
public class 导师请吃火 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = br.read()-'0';br.skip(1);
            int m = br.read()-'0';br.skip(1);
            boolean[] dish = new boolean[2001];
            int[] dp = new int[2001];
            int end = 0;
            for (int i = 1; i <= n; i++) {
                int a = br.read()-'0';
                br.skip(1);
                int b = br.read()-'0';
                br.skip(1);
                dish[a+b] = true;
                end = Math.max(a+b, end);
            }
            for (int i = 2; i <= end; i++) {
                if (dish[i] && i-m > 0){
                    dp[i] = Math.max(dp[i-m]+1, dp[i-1]);
                }else if(dish[i]) {
                    dp[i] = dp[i-1] + 1;
                }else {
                    dp[i] = dp[i-1];
                }
            }
            System.out.println(dp[end]);
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
