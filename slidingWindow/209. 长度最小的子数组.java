package slidingWindow;

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, min = 0, k = 0;
        for (int i = 0; i <= nums.length; i++) {
            // 移动右边窗口
            while (sum < target && i < nums.length) {
                sum += nums[i++];
            }
            if (sum >= target) {
                // 更新最小窗口
                min = min == 0 ? i - k : Math.min(i - k, min);
            }
            // 越界直接结束
            if (sum < target && i >= nums.length) {
                break;
            }
            // 移动左边窗口
            sum -= nums[k];
            k++;
            i--;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution209 s = new Solution209();
        s.minSubArrayLen(11, new int[] { 2, 3, 1, 2, 4, 3 });
    }
}
