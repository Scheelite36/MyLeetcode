package prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 长度为0 时候和为0
        map.put(0, 0);
        int max = 0;
        for (int i = 1; i < n+1; i++) {
            int m = s[i];
            // 如果碰到了相同的数 说明 区间和s[j]-s[i-1] = 0 0和1数量相同
            if(map.containsKey(m)) max = Math.max(max, i-map.get(m));
            else map.put(m, i);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution525 s = new Solution525();
        System.out.println(s.findMaxLength(new int[] { 0, 0, 1, 0, 0, 0, 1, 1 }));
    }
}
