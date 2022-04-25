import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int[] isPrimes = new int[n];
        // make a array 1 represent the prime
        Arrays.fill(isPrimes, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i] == 1) {
                ans++;
            }
            // mark all composite number by the multiple of prime
            if ((long) i * i < n) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j]=0;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
