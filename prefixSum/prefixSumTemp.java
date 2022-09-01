package prefixSum;

public class prefixSumTemp {
    // 一维
    public void prefixSum(int[] nums) {
        // 这里假定 nums是从下标1开始有效的
        int[] s = new int[nums.length];
        for (int i = 1; i <= nums.length; i++) {
            s[i] = s[i - 1] + nums[i];
        }
        // 算部分和
        // 此时如果求 i 到 j 的 和就等于 s[j]-s[i-1]
    }

    // 二维
    public void prefixSum2(int[][] nums) {
        // 这里假定 nums是从下标1开始有效的
        int[][] s = new int[nums.length][nums[0].length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                s[i][j] = s[i][j-1] + s[i-1][j] - s[i-1][j-1] + nums[i][j];
            }
        }
        // 算部分和
        // 此时如果求 x1 y1 到 x2 y2 的 和就等于
        // s[x2][y2]-s[x1-1][y2]-s[x2][y1-1]+s[x1-1][y1-1]
    }
}
